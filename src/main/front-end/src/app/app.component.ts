import { Component } from '@angular/core';
import { AuthService } from './auth/auth.service';
import { NotificationService } from './notification/notification.service';
import { Router } from "@angular/router";
import { interval, Observable } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'front-end';
  notifications: Notification[] = [];
  notViewed: Notification[] = [];
  isAuthenticated = false;
  lol = false;

  constructor(private AuthService: AuthService, private router: Router, private NotificationService: NotificationService) {
  }

  ngOnInit(): void {
    interval(1000).subscribe((val) => { this.getNotification(JSON.parse(localStorage.getItem('user'))['data'].id);
                                        this.getNotViewCount(JSON.parse(localStorage.getItem('user'))['data'].id);
                                      });
  }

  logout(){
    console.log('logout');
    localStorage.setItem("user", null);
    localStorage.removeItem("user");
    this.AuthService.logout();
    this.router.navigateByUrl('/auth');
  }

  authenticated() {
    let user = localStorage.getItem("user");
    if(user == undefined || user == null) {
      this.isAuthenticated = false;
    } else {
      this.isAuthenticated = true;
    }
   return this.isAuthenticated;
  }

  getNotViewCount(id: string) {
    this.NotificationService.getNotViewCount(id).subscribe( (notViewed: any[]) => {
      this.notViewed = notViewed;
    });
  }

  getNotification(id: string) {
    this.NotificationService.getUserNotification(id).subscribe( (notifications: any[]) => {
      this.notifications = notifications;
    });
  }

  deleteNotification(id: string) {
    this.NotificationService.delete(id).subscribe();
  }

  setViewedNotification(id: string) {
    this.NotificationService.setViewed(id).subscribe();
  }
}
