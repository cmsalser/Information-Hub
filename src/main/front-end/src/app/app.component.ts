import { Component } from '@angular/core';
import { AuthService } from './auth/auth.service'
import { Router } from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'front-end';
  isAuthenticated = false;

  constructor(private AuthService: AuthService, private router: Router) {
  }

  logout(){
    console.log('logout');
    localStorage.setItem("user", null);
    localStorage.removeItem("user");
    this.AuthService.logout();
    this.router.navigateByUrl('/auth');
  }

  authenticated() {
    //return this.AuthService.authenticated;
    let user = localStorage.getItem("user");
    if(user == undefined || user == null) {
      this.isAuthenticated = false;
    } else {
     this.isAuthenticated = true;
    }
   return this.isAuthenticated;
  }
}
