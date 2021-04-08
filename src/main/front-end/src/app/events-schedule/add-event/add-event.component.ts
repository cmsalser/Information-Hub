import { Component, OnInit } from '@angular/core';
import { Event } from '../../models/event.model';
import { Router } from "@angular/router";
import { EventsScheduleService } from '../events-schedule.service';


@Component({
  selector: 'app-add-event',
  templateUrl: './add-event.component.html',
  styleUrls: ['./add-event.component.css']
})
export class AddEventComponent implements OnInit {

  newEvent = {} as Event;

  constructor(private Router: Router, private EventsScheduleService: EventsScheduleService) { }

  ngOnInit(): void {
    this.newEvent.userId = JSON.parse(localStorage.getItem('user')).id;
  }
  createEvent() {
    const body = JSON.stringify(this.newEvent);
    console.log(body)
    this.EventsScheduleService.addEvent(body).subscribe(
      () => {
        this.Router.navigateByUrl('/schedule');
      })
  }
}
