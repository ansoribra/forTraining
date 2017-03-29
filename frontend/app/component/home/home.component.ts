import { Component, OnInit } from '@angular/core';
import {Home} from "./home";
import {CategoryService} from "./../../service/category.service";
import { Router } from '@angular/router';
import { environment } from "../../../environments/environment"

@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers: [CategoryService]
})

export class HomeComponent implements OnInit {
  server= environment.dataserve;
  errorMessage: string;
  computers: Home[];
  beauties: Home[];
  books: Home[];
  clothings: Home[];
  shoes: Home[];
  electronics: Home[];
  games: Home[];
  gardens: Home[];
  healths: Home[];
  homes: Home[];
  jeweleries: Home[];
  kids: Home[];
  movies: Home[];
  outdoors: Home[];
  sports: Home[];

  constructor (private categoryService: CategoryService) {
  }

  ngOnInit() { this.getHomes(); }

  getHomes() {
    this.categoryService.getComputer()
        .subscribe(computers => this.computers = computers.content,
                   error => this.errorMessage = <any>error);

    this.categoryService.getBeauty()
        .subscribe(beauties => this.beauties = beauties.content,
                   error => this.errorMessage = <any>error);

    this.categoryService.getBook()
        .subscribe(books => this.books = books.content,
                   error => this.errorMessage = <any>error);

    this.categoryService.getClothing()
        .subscribe(clothings => this.clothings = clothings.content,
                   error => this.errorMessage = <any>error);

    this.categoryService.getGarden()
        .subscribe(gardens => this.gardens = gardens.content,
                   error => this.errorMessage = <any>error);

    this.categoryService.getElectronic()
        .subscribe(electronics => this.electronics = electronics.content,
                   error => this.errorMessage = <any>error);

    this.categoryService.getGames()
        .subscribe(games => this.games = games.content,
                   error => this.errorMessage = <any>error);

    this.categoryService.getHealth()
        .subscribe(healths => this.healths = healths.content,
                   error => this.errorMessage = <any>error);

    this.categoryService.getHome()
        .subscribe(homes => this.homes = homes.content,
                   error => this.errorMessage = <any>error);

    this.categoryService.getJewelery()
        .subscribe(jeweleries => this.jeweleries = jeweleries.content,
                   error => this.errorMessage = <any>error);

    this.categoryService.getKids()
        .subscribe(kids => this.kids = kids.content,
                   error => this.errorMessage = <any>error);

    this.categoryService.getMovies()
        .subscribe(movies => this.movies = movies.content,
                   error => this.errorMessage = <any>error);

    this.categoryService.getOutdoors()
        .subscribe(outdoors => this.outdoors = outdoors.content,
                   error => this.errorMessage = <any>error);

    this.categoryService.getSport()
        .subscribe(sports => this.sports = sports.content,
                   error => this.errorMessage = <any>error);

    this.categoryService.getShoes()
        .subscribe(shoes => this.shoes = shoes.content,
                   error => this.errorMessage = <any>error);
  }

  public currentPage:number = 1;
  public totalItems:number = 200; // total numbar of page not items
  public maxSize:number = 10; // max page size

  public setPage(pageNo:number):void {
    this.currentPage = pageNo;
  };

  public pageChanged(event:any):void {
//this method will trigger every page click
    console.log('Number items per page: ' + event.itemsPerPage);
  };
}
