import { Component, OnInit } from '@angular/core';
import { AuthService } from './auth.service';
import { Router } from "@angular/router";

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {
  credentials = {username: '', password: ''};

  constructor(private AuthService: AuthService, private router: Router) { }

  ngOnInit(): void {
  }

  login() {
    this.AuthService.authenticate(this.credentials, (user) => {
      if(user == null) {
        alert("Invalid credential")
      } else {
        this.router.navigateByUrl('/');
      }
    });
  }
}
