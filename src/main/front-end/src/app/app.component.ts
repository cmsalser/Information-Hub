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

  constructor(private authService: AuthService, private router: Router) {
  }

  logout(){
    this.authService.logOut();
    this.router.navigateByUrl('/auth');
  }

  authenticated() {
    console.log(this.authService.authenticated);
    return this.authService.authenticated;
  }
}
