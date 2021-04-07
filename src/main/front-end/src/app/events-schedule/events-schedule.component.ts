import { Component, OnInit } from '@angular/core';
import { Event } from '../models/event.model'; // edit from  '../../models/event.model'; wasnt working
import { EventsScheduleService } from './events-schedule.service'; // '../events-schedule.service'; error
import { AuthService } from '../auth/auth.service';


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
}