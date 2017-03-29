import { Component, OnInit } from '@angular/core';
import {CategoryService} from '../../service/category.service';
import { ActivatedRoute,Router } from '@angular/router';
import { environment } from "../../../environments/environment"
import {DetailprodService} from './../../service/detailprod.service';
import {Home} from '../home/home';

@Component({
  selector: 'app-detailprod',
  templateUrl: './detailprod.component.html',
  styleUrls: ['./detailprod.component.css'],
  providers: [DetailprodService]
})
export class DetailprodComponent implements OnInit {
  errorMessage: string;
  server= environment.dataserve;
  id:string;
  store_id:string;
  product_name:string;
  product_description:string;
  product_price:string;
  product_discount:string;
  product_discount_after:string;
  product_rating:number;
  product_sold:string;
  product_image_total:number;
  image_number:number=1;
  private sub: any;
  starspath:string;
  items:any;
  searchValue:string;
  visibility:string='visible';


  constructor(private detailprodService:DetailprodService,private route: ActivatedRoute) {
    window.scrollTo(0,0);
  }

  ngOnInit() {
     this.route.params.subscribe(params => {let   id = params['id'];this.id = id;});

    this.detailprodService.getDetail()
         .subscribe(details => this.store_id = details.product_store_id,
            error => this.errorMessage = <any>error);

    this.detailprodService.getDetail()
        .subscribe(details => this.product_name = details.product_name,
            error => this.errorMessage = <any>error);

    this.detailprodService.getDetail()
        .subscribe(details => this.product_description = details.product_description,
            error => this.errorMessage = <any>error);

    this.detailprodService.getDetail()
        .subscribe(details => this.product_price = details.product_price,
            error => this.errorMessage = <any>error);

    this.detailprodService.getDetail()
        .subscribe(details => this.product_discount = details.product_discount,
            error => this.errorMessage = <any>error);

    this.detailprodService.getDetail()
        .subscribe(details => this.product_discount_after = details.product_discount_after,
            error => this.errorMessage = <any>error);

    this.detailprodService.getDetail()
        .subscribe(details => this.product_sold = details.product_sold,
            error => this.errorMessage = <any>error);

    this.detailprodService.getDetail()
        .subscribe(details => {
          this.product_rating = details.product_rating;
          this.getstars(this.product_rating);
        }, error => this.errorMessage = <any>error);

    this.detailprodService.getDetail()
        .subscribe(details => {
          this.product_image_total = details.product_image_total;
          this.setProductImageTotal(this.product_image_total);
        }, error => this.errorMessage = <any>error);
  }

  searchCalled(message:string):void{
    this.searchValue=message;
  }

  getstars(x){
    if (x == 1){
      this.starspath ="imagemanagement/1stars.png";
    }else if (x == 2){
      this.starspath ="imagemanagement/2stars.png";
    }else if (x == 3){
      this.starspath ="imagemanagement/3stars.png";
    }else if (x <= 8){
      this.starspath ="imagemanagement/4stars.png";
    }else if (x <= 10){
      this.starspath ="imagemanagement/5stars.png";
    }
  }

  setProductImageTotal(x){
    this.product_image_total= x;
  }

  createRange(){
    this.items = [];
    for (var i = 1; i <= this.product_image_total; i++) {
        this.items.push(i);
      }
    return this.items;
  }

  changeimage(x){
    this.image_number=x;
  }
}
