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
  // showNotificaiton:boolean = false;

  constructor(private AuthService: AuthService, private router: Router) {
  }

  logout(){
    console.log('logout');
    this.AuthService.logout();
    this.router.navigateByUrl('/auth');
  }

  authenticated() {
    return this.AuthService.authenticated;
  }

  // div1:boolean=true;

  // div1Function(){
  //     this.div1= !this.div1;
  // }
}
