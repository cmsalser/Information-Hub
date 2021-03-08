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
}
