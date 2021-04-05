import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  account = {
    username: "",
    firstname: "",
    lastname: "",
    phoneNumber: "",
    email: "",
    threads: {}
  };

  constructor( private router: Router) { }

  ngOnInit(): void {
    this.account = JSON.parse(localStorage.getItem('user'))['data'];
    console.log(this.account);
  }

}
