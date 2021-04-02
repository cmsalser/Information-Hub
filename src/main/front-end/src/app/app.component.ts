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
  isAuthenticated = false;


  constructor(private AuthService: AuthService, private router: Router, private NotificationService: NotificationService) {
  }

  ngOnInit(): void {
    interval(1000).subscribe((val) => { this.getNotification(); });
  }

  logout(){
    console.log('logout');
    localStorage.setItem("user", null);
    localStorage.removeItem("user");
    this.AuthService.logout();
    this.router.navigateByUrl('/auth');
  }

  authenticated() {
    //return this.AuthService.authenticated;
    let user = localStorage.getItem("user");
    if(user == undefined || user == null) {
      this.isAuthenticated = false;
    } else {
     this.isAuthenticated = true;
    }
   return this.isAuthenticated;
  }

  getNotification() {
    this.NotificationService.findAll().subscribe( (notifications: any[]) => {
      // this.notifications = Object.values(notifications);
      // console.log(this.notifications.length);
      // console.log(this.notifications);
      this.notifications = notifications;
      // console.log(this.notifications.length);
      // console.log(this.notifications);
    });
  }

  deleteNotification(id: string) {
    this.NotificationService.delete(id).subscribe();
  }

  // div1:boolean=true;

  // div1Function(){
  //     this.div1= !this.div1;
  // }
}
