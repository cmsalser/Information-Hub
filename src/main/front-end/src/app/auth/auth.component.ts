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
    localStorage.setItem("user", null);
    localStorage.removeItem("user");
  }

  login() {
    this.AuthService.authenticate(this.credentials, (user) => {
      if(user == null) {
        alert("Invalid credential")
      } else {
        localStorage.setItem("user",JSON.stringify(user));
        this.router.navigateByUrl('/');
      }
    });
  }
}
