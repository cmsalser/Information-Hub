import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from "../models/user.model";


@Injectable({
  providedIn: 'root'
})
export class AuthService {
  authenticated = false;
  adminStatus = true;
  user;

  constructor(private http: HttpClient) {

  }

  authenticate(credentials, callback) {

    this.http.get('https://jsonplaceholder.typicode.com/users?username=' + credentials.username).subscribe((response: User) => {
        this.user = response;
        this.authenticated = true;
        console.log(this.user);
      return callback && callback();
    });

  }

  logout() {
    this.authenticated = false;
  }
  }
