import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { User } from "../models/user.model";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  authenticated = false;
  adminStatus = false;
  user;

  constructor(private http: HttpClient) {
  }

  // authenticate(credentials, callback) {
  //   this.http.get('https://jsonplaceholder.typicode.com/users?username=' + credentials.username).subscribe((response: User) => {
  //       this.user = response;
  //       this.authenticated = true;
  //       console.log(this.user);
  //     return callback && callback();
  //   });
  // }
  //
  // logout() {
  //   this.authenticated = false;
  //   this.http.post('logout', {}).subscribe()
  // }

  authenticate(username, password) {
    if (username === "javainuse" && password === "password") {
      sessionStorage.setItem('username', username)
      this.authenticated = true;
    } else {
      this.authenticated = false;
    }
    return this.authenticated;
  }

  logOut() {
    sessionStorage.removeItem('username')
    this.authenticated = false;
  }

}
