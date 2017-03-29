import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import {Home} from "../home/home";
import {CategoryService} from "../../service/category.service";
import { environment } from "../../../environments/environment"

@Component({
  selector: 'app-seemore',
  templateUrl: './seemore.component.html',
  styleUrls: ['./seemore.component.css'],
  providers: [CategoryService]
})

export class SeemoreComponent implements OnInit {
  server=environment.dataserve;
  id:string;
  idCat:string;
  prevactive:string;
  nextactive:string;
  prevpointeractive:string;
  nextpointeractive:string;
  totalpages:number;
  navigationtotal:number=10;
  indexpagination:number=1;
  currentrest:number;
  restpage:number;
  categories:Home[];
  items:any;
  elementExist:any;
  container:any={};
  blocknext:any;
  currentpage =0;
  searchValue:string;
  visibility:string='visible';
  errorMessage: string;
  private sub: any;

  constructor(private categoryService:CategoryService,private route: ActivatedRoute) {
    this.id = '?';
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {let   id = params['id'];this.id = id;});
    this.getHomes();
    this.paginationcontrol();
  }

  searchCalled(message:string):void{
    this.searchValue=message;
  }

  createRange(totalpages,indexpagination){
    this.totalpages=totalpages;
    this.items = [];
    this.currentrest = 10*(indexpagination-1);
    if (totalpages<=10*indexpagination) {
        this.blocknext=true;
        this.restpage = totalpages - this.currentrest;
        for(var i = this.currentrest; i <= totalpages-1; i++){
            this.items.push(i);
      }
    }else {
      if (indexpagination > 1) {
        this.restpage = totalpages - this.currentrest;
        for(var i = this.currentrest; i <= 10*indexpagination; i++){
          this.items.push(i);
        }
      } else {
        for (var i = 0; i <= totalpages; i++) {
          if (i < this.navigationtotal) {
            this.items.push(i);
          }
        }
      }
    }
    return this.items;
  }

  normalizepage(object){
    object = object+1;
    return object;
  }

  handleClick(event) {
    for(var i =0; i <=this.totalpages; i++){
      this.elementExist = document.getElementById("refferednumber"+i);
      if(this.elementExist){
        this.elementExist.style.background = "rgba(255, 0, 0, 0.46)";
      }
    }
    document.getElementById("refferednumber"+event).style.background = "red";
  }

  paginationcontrol(){
    if (this.indexpagination<=1){
      this.prevactive ="black";
      this.prevpointeractive="none";
    }else {
      this.prevactive ="rgba(255, 0, 0, 0.46)";
      this.prevpointeractive="auto";
    }

    if (this.blocknext) {
      this.nextactive = "black";
      this.nextpointeractive = "none";
    }else {
      this.nextactive ="rgba(255, 0, 0, 0.46)";
      this.nextpointeractive="auto";
    }
  }

  moveto(number){
    this.currentpage=number;
    this.categoryService.changePage(this.currentpage);
    this.getHomes();
    this.paginationcontrol();
  }

  next(){
    this.createRange(this.totalpages,++this.indexpagination);
    this.getHomes();
    this.paginationcontrol();
  }

  prev(){
    this.blocknext=false;
    this.createRange(this.totalpages,--this.indexpagination);
    this.paginationcontrol();
    this.getHomes();
  }

  getHomes(){
    if (this.id==='1') {
      this.idCat = "COMPUTER PRODUCT";
      this.categoryService.getComputerFull()
          .subscribe(categories => this.categories = categories.content,
              error => this.errorMessage = <any>error);

      this.categoryService.getComputerFull()
          .subscribe(totalpages => this.totalpages = totalpages.totalPages,
              error => this.errorMessage = <any>error);

    }else if (this.id==='2'){
      this.idCat = "BEAUTY PRODUCT";
      this.categoryService.getBeautyFull()
          .subscribe(categories => this.categories = categories.content,
              error => this.errorMessage = <any>error);

      this.categoryService.getBeautyFull()
          .subscribe(totalpages => this.totalpages = totalpages.totalPages,
              error => this.errorMessage = <any>error);

    }else if (this.id==='3'){
      this.idCat = "BOOK PRODUCT";
      this.categoryService.getBookFull()
          .subscribe(categories => this.categories = categories.content,
              error => this.errorMessage = <any>error);

      this.categoryService.getBookFull()
          .subscribe(totalpages => this.totalpages = totalpages.totalPages,
              error => this.errorMessage = <any>error);

    }else if (this.id==='4'){
      this.idCat = "CLOTHING PRODUCT";
      this.categoryService.getClothingFull()
          .subscribe(categories => this.categories = categories.content,
              error => this.errorMessage = <any>error);

      this.categoryService.getClothingFull()
          .subscribe(totalpages => this.totalpages = totalpages.totalPages,
              error => this.errorMessage = <any>error);

    }else if (this.id==='5'){
      this.idCat = "SHOES PRODUCT";
      this.categoryService.getShoesFull()
          .subscribe(categories => this.categories = categories.content,
              error => this.errorMessage = <any>error);

      this.categoryService.getShoesFull()
          .subscribe(totalpages => this.totalpages = totalpages.totalPages,
              error => this.errorMessage = <any>error);

    }else if (this.id==='6'){
      this.idCat = "ELEKTRONIK PRODUCT";
      this.categoryService.getElectronicFull()
          .subscribe(categories => this.categories = categories.content,
              error => this.errorMessage = <any>error);

      this.categoryService.getElectronicFull()
          .subscribe(totalpages => this.totalpages = totalpages.totalPages,
              error => this.errorMessage = <any>error);

    }else if (this.id==='7'){
      this.idCat = "GAMES PRODUCT";
      this.categoryService.getGamesFull()
          .subscribe(categories => this.categories = categories.content,
              error => this.errorMessage = <any>error);

      this.categoryService.getGamesFull()
          .subscribe(totalpages => this.totalpages = totalpages.totalPages,
              error => this.errorMessage = <any>error);

    }else if (this.id==='8'){
      this.idCat = "GARDEN PRODUCT";
      this.categoryService.getGardenFull()
          .subscribe(categories => this.categories = categories.content,
              error => this.errorMessage = <any>error);

      this.categoryService.getGardenFull()
          .subscribe(totalpages => this.totalpages = totalpages.totalPages,
              error => this.errorMessage = <any>error);

    }else if (this.id==='9'){
      this.idCat = "HEALTH PRODUCT";
      this.categoryService.getHealthFull()
          .subscribe(categories => this.categories = categories.content,
              error => this.errorMessage = <any>error);

      this.categoryService.getHealthFull()
          .subscribe(totalpages => this.totalpages = totalpages.totalPages,
              error => this.errorMessage = <any>error);

    }else if (this.id==='10'){
      this.idCat = "HOME PRODUCT";
      this.categoryService.getHomeFull()
          .subscribe(categories => this.categories = categories.content,
              error => this.errorMessage = <any>error);

      this.categoryService.getHomeFull()
          .subscribe(totalpages => this.totalpages = totalpages.totalPages,
              error => this.errorMessage = <any>error);

    }else if (this.id==='11'){
      this.idCat = "JEWELERY PRODUCT";
      this.categoryService.getJeweleryFull()
          .subscribe(categories => this.categories = categories.content,
              error => this.errorMessage = <any>error);

      this.categoryService.getJeweleryFull()
          .subscribe(totalpages => this.totalpages = totalpages.totalPages,
              error => this.errorMessage = <any>error);

    }else if (this.id==='12'){
      this.idCat = "KIDS PRODUCT";
      this.categoryService.getKidsFull()
          .subscribe(categories => this.categories = categories.content,
              error => this.errorMessage = <any>error);

      this.categoryService.getKidsFull()
          .subscribe(totalpages => this.totalpages = totalpages.totalPages,
              error => this.errorMessage = <any>error);

    }else if (this.id==='13'){
      this.idCat = "MOVIES PRODUCT";
      this.categoryService.getMoviesFull()
          .subscribe(categories => this.categories = categories.content,
              error => this.errorMessage = <any>error);

      this.categoryService.getMoviesFull()
          .subscribe(totalpages => this.totalpages = totalpages.totalPages,
              error => this.errorMessage = <any>error);

    }else if (this.id==='14') {
      this.idCat = "OUTDOORS PRODUCT";
      this.categoryService.getOutdoorsFull()
          .subscribe(categories => this.categories = categories.content,
              error => this.errorMessage = <any>error);

      this.categoryService.getOutdoorsFull()
          .subscribe(totalpages => this.totalpages = totalpages.totalPages,
              error => this.errorMessage = <any>error);

    }else if (this.id==='15') {
      this.idCat = "SPORT PRODUCT";
      this.categoryService.getSportFull()
          .subscribe(categories => this.categories = categories.content,
              error => this.errorMessage = <any>error);

      this.categoryService.getSportFull()
          .subscribe(totalpages => this.totalpages = totalpages.totalPages,
              error => this.errorMessage = <any>error);
    }
  }
}
