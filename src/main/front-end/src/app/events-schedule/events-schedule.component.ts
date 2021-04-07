import { Component, OnInit } from '@angular/core';
import { Event } from '../models/event.model';
import { EventsScheduleService } from './events-schedule.service';
import { AuthService } from '../auth/auth.service';
import * as moment from "moment";

@Component({
  selector: 'app-events-schedule',
  templateUrl: './events-schedule.component.html',
  styleUrls: ['./events-schedule.component.css']
})
export class EventsScheduleComponent implements OnInit {

  events: Event[] = [];


  constructor(private EventsScheduleService: EventsScheduleService, private AuthService: AuthService) {

   }

  ngOnInit(): void {
    this.EventsScheduleService.getEvents()
    .subscribe(
      (events: any[]) => {
        this.events = events;
      })
  }

  isAdmin() {
    return this.AuthService.isAdmin();
  }

  deleteEvent(id) {
    return this.EventsScheduleService.deleteEvent(id).subscribe();
  }

  parseJsonDate(jsonDateString) {
    return moment(jsonDateString).format("YYYY-MM-DD HH:mm");
  }
}
