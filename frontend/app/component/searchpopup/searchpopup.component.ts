import { Component, OnInit,Input } from '@angular/core';
import {HomeService} from "../../service/home.service";
import {Home} from "../home/home";
import {SearchService} from "../../service/search.service";
import 'rxjs/Rx';

@Component({
  selector: 'app-searchpopup',
  templateUrl: './searchpopup.component.html',
  styleUrls: ['./searchpopup.component.css'],
  providers: [SearchService]
})

export class SearchpopupComponent implements OnInit {
  loading:any;
  @Input() sendvisi;
  visibility:string="hidden";
  searchMenuShrink : string = '';
  @Input() term:string;

  refresh(){
    window.location.reload();
  }
  searchmenu(){
    this.visibility= "visible";
  }

  searchmenuhide(){
    this.visibility= "hidden";
  }

  ngOnInit() {
    this.visibility =this.sendvisi;
    this.getHomes();
    this.loadersearch();
  }

  onScrolled(yPos : number) {
    this.searchMenuShrink = yPos ? "searchmenu-shrink" : "";
  }

  errorMessage: string;
  services: Home[];
  constructor (private homeService: SearchService) {
  }

  getHomes() {
    this.homeService.getService()
        .subscribe(
            services => this.services = services.content,
            error =>  this.errorMessage = <any>error);
  }

  loadersearch(){

  }
}
