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
  //
  // constructor(private authService: AuthService, private router: Router) {}
  //
  // ngOnInit(): void {
  // }
  //
  // login() {
  //   this.authService.authenticate(this.credentials, () => {
  //     this.router.navigateByUrl('/');
  //   });
  //   return false;
  // }

  constructor(private router: Router,
              private loginservice: AuthService) { }

  ngOnInit() {
  }

  login() {
    if (this.loginservice.authenticate(this.credentials.username, this.credentials.password)
    ) {
      this.router.navigate([''])
    }
  }
}
