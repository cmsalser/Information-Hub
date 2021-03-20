import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {User} from "../models/user.model";
import {FormGroup} from "@angular/forms";
import {Observable} from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class UserService {

  public signUpForm: FormGroup;

  constructor(private http: HttpClient) { }

  register(user: User): Observable<User> {
    return this.http.post<User>('http://localhost:8080/user/signup', user);
  }
}
