import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
  })
  export class NotificationService {
  
    private notificationURL: string;
  
    constructor(private http: HttpClient) {
      this.notificationURL = 'http://localhost:8080/notification';
    }

    public findAll(): Observable<Object> {
      return this.http.get(this.notificationURL);
    }
  
    public get(id: string): Observable<Object> {
      return this.http.get(this.notificationURL + '/' + id);
    }

    public setViewed(id: string) {
      return this.http.get(this.notificationURL + '/' + id + '/viewed');
    }
  
    public delete(id: string) {
      return this.http.delete(this.notificationURL + '/0/' + id);
    }

    public getNotViewCount() {
      return this.http.get(this.notificationURL + '/viewcount');
    }
  }