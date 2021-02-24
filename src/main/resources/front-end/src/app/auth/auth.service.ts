import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  authenticated = true;
  adminStatus = true;
  
  constructor(private http: HttpClient) { }

    authenticate(credentials, callback) {

      const headers = new HttpHeaders({
        username: credentials.username,
        password: credentials.password,
    });

      console.log(headers);

      this.http.get('user', {headers: headers}).subscribe(response => {
          if (response['name']) {
              this.authenticated = true;
              console.log(response);
          } else {
              this.authenticated = false;
              console.log(response);
          }
          return callback && callback();
      });

    }

    logout() {
      this.authenticated = false;
    }
  }
