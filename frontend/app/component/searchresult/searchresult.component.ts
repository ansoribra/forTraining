import { Component, OnInit } from '@angular/core';
import { Http, Response } from '@angular/http';
import { ActivatedRoute,Router } from '@angular/router';
import { environment } from "../../../environments/environment"

@Component({
  selector: 'app-searchresult',
  templateUrl: './searchresult.component.html',
  styleUrls: ['./searchresult.component.css']
})
export class SearchresultComponent implements OnInit {
  name:string;
  searches:any;
  errorMessage: string;
  server:string=environment.dataserve;
  pageNumber:string;
  private page=0;
  prevactive:string;
  nextactive:string;
  prevpointeractive:string;
  nextpointeractive:string;
  totalpages:number;
  navigationtotal:number=10;
  indexpagination:number=1;
  currentrest:number;
  restpage:number;
  items:any;
  elementExist:any;
  container:any={};
  blocknext:any;
  currentpage =0;
  searchValue:string;
  visibility:string='visible';

  constructor(private http: Http,private route: ActivatedRoute,  public router: Router) {
    this.router.events.pairwise().subscribe((e) => {this.refresh()});
    this.route.params.subscribe(params => {let name = params['name'];this.name = name; });
    this.getSearch();
  }

  ngOnInit() {
    this.paginationcontrol();
  }

  refresh(){
    window.location.reload();
  }

  searchCalled(message:string):void{
    this.searchValue=message;
  }

  getSearch() {
    this.http.get(this.server+'/product?product_name='+this.name+'&page='+this.page+'&size=60')
        .map(res => res.json())
        .subscribe(searches => {this.searches = searches.content;console.log(this.searches)},
            error => this.errorMessage = <any>error);

    this.http.get(this.server+'/product?product_name='+this.name+'&page='+this.page+'&size=60')
        .map(res => res.json())
        .subscribe(totalpages => this.totalpages = totalpages.totalPages,
            error => this.errorMessage = <any>error);
  }

  changePage( pageNumber){
    this.page =pageNumber;
    this.getSearch();
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
    this.changePage(this.currentpage);
    this.getSearch();
    this.paginationcontrol();
  }

  next(){
    this.createRange(this.totalpages,++this.indexpagination);
    this.getSearch();
    this.paginationcontrol();
  }

  prev(){
    this.blocknext=false;
    this.createRange(this.totalpages,--this.indexpagination);
    this.paginationcontrol();
    this.getSearch();
  }
}
