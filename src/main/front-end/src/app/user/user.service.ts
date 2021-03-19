import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {config} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  // register(user) {
  //   return this.http.post(`${config.apiUrl}/users/register`, user);
  // }
}
