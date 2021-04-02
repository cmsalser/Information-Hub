import { Component, OnInit } from '@angular/core';
import { interval } from 'rxjs';
import { NotificationService } from './notification.service';

@Component({
  selector: 'app-notification',
  templateUrl: './notification.component.html',
  styleUrls: ['./notification.component.css']
})
export class NotificationComponent implements OnInit {
  notifications: Notification[] = [];

  constructor(private NotificationService: NotificationService) { }

  ngOnInit(): void {
    interval(1000).subscribe((val) => { this.getNotification(); });
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
    this.NotificationService.delete(id);
  }
}
