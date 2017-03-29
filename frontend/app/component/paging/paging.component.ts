import { Component, OnInit } from '@angular/core';
import {SeemoreComponent} from "../seemore/seemore.component";
import {CategoryService} from "../../service/category.service";

@Component({
  selector: 'app-paging',
  templateUrl: './paging.component.html',
  styleUrls: ['./paging.component.css']
})
export class PagingComponent implements OnInit {
  prevactive:string;
  movetoactive:string;
  nextactive:string
  prevpointeractive:string;
  nextpointeractive:string;
  private  currentpage =1;
  totalpages:number;
  items:any;

  constructor( public seemore:SeemoreComponent, public categoryService:CategoryService) {

  }

  ngOnInit() {
    this.paginationcontrol();
  }

  createRange(number){
    this.items = [];
    for(var i = 2; i <= number; i++){
      if(i<7) {
        this.items.push(i);
      }
    }
    return this.items;
  }

  handleClick(event) {
    for(var i =2; i <=6; i++){
      document.getElementById("refferednumber"+i).style.background = "rgba(255, 0, 0, 0.46)";
    }
    document.getElementById("refferednumber"+event).style.background = "red";

  }

  paginationcontrol(){
    if (this.currentpage<=1){
      this.prevactive ="black";
      this.prevpointeractive="none";
    }else if (this.currentpage>=this.totalpages-1) {
      this.nextactive = "black";
      this.nextpointeractive = "none";
    }else {
      this.prevactive ="rgba(255, 0, 0, 0.46)";
      this.nextactive ="rgba(255, 0, 0, 0.46)";
      this.nextpointeractive="auto";
      this.prevpointeractive="auto";
    }
  }

  moveto(number){
    this.currentpage=number;
    this.categoryService.changePage(this.currentpage);
    this.seemore.getHomes();
    this.paginationcontrol();
  }

  next(){
    this.categoryService.changePage(++this.currentpage);
    this.seemore.getHomes();
    this.paginationcontrol();
  }

  prev(){
    this.categoryService.changePage(--this.currentpage);
    this.paginationcontrol();
    this.seemore.getHomes();
  }

}
