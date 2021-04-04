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

    public getUserNotification(id: string) {
      return this.http.get(this.notificationURL + '/user/' + id);
    }

    public setViewed(id: string) {
      return this.http.get(this.notificationURL + '/' + id + '/viewed');
    }
  
    public delete(id: string, userId: string) {
      return this.http.delete(this.notificationURL + '/' + userId +'/' + id);
    }

    public getNotViewCount(id: string) {
      return this.http.get(this.notificationURL + '/viewcount/' + id);
    }
  }