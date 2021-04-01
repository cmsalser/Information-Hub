import { Component, OnInit } from '@angular/core';
import { NotificationService } from './notification.service';

@Component({
  selector: 'app-notification',
  templateUrl: './notification.component.html',
  styleUrls: ['./notification.component.css']
})
export class NotificationComponent implements OnInit {
  notifications: Notification[] = [];

  constructor(private NotificaitonService: NotificationService) { }

  ngOnInit(): void {
    this.NotificaitonService.findAll().subscribe( (notifications: any[]) => {
      // this.notifications = Object.values(notifications);
      // console.log(this.notifications.length);
      // console.log(this.notifications);
      this.notifications = notifications;
      console.log(this.notifications.length);
      console.log(this.notifications);
    })
  }

  // showNotification: boolean;  
  // constructor(){}
  
  // openNotification(state: boolean) {
  //   this.showNotification = state;
  // }
}
