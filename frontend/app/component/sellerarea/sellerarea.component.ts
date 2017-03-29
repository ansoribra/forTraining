import { Component, OnInit } from '@angular/core';
import {UserService} from "../../service/user.service";
import {Home} from "../home/home";
import {CategoryService} from "../../service/category.service";

@Component({
  selector: 'app-sellerarea',
  templateUrl: './sellerarea.component.html',
    styleUrls: ['./sellerarea.component.css']
})
export class SellerareaComponent implements OnInit {
  users: Home[];
  computers: Home[];
  errorMessage: string;
  constructor(private userService: UserService, private categoryService:CategoryService) { }

  ngOnInit() {
    this.userService.getUser()
        .subscribe(users => this.users = users.content,
            error => this.errorMessage = <any>error);

    this.categoryService.getComputer()
        .subscribe(computers => this.computers = computers.content,
            error => this.errorMessage = <any>error);
  }
}
