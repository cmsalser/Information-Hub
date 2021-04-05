import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
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

  // getAll(): Observable<Array<User>> {
  //   return this.http.get<Array<User>>('http://localhost:8080/user/')
  // }

  checkUsernameExists(username: string): Observable<boolean> {
    return this.http.post<boolean>('http://localhost:8080/user/username', new HttpParams().set('username', username))
  }

  checkEmailExists(email: string): Observable<boolean> {
    return this.http.post<boolean>('http://localhost:8080/user/email', new HttpParams().set('email', email))
  }
}
