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

    this.http.post('http://localhost:8080/user/signin', credentials).subscribe((response: User) => {

      this.user = response;
      this.authenticated = true;
      if (this.user.code == 200) {
        return callback && callback(this.user);
      } else {
        return callback && callback(null);
      }

    });

  }

  isAuthenticated() {
    let user = localStorage.getItem("user");
    return user !== undefined && user !== null;
  }

  logout() {
    this.authenticated = false;
  }
}
