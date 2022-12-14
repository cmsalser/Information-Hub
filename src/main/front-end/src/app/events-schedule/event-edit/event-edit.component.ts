import { Component, OnInit } from '@angular/core';
import { Event } from '../../models/event.model';
import { ActivatedRoute, Params, Router } from "@angular/router";
import { EventsScheduleService } from '../events-schedule.service';
import * as moment from "moment";


@Component({
  selector: 'app-event-edit',
  templateUrl: './event-edit.component.html',
  styleUrls: ['./event-edit.component.css']
})
export class EventEditComponent implements OnInit {

  editedEvent = {} as Event;

  constructor(private Router: Router, private EventsScheduleService: EventsScheduleService, private Route: ActivatedRoute) { }

  ngOnInit(): void {
    this.Route.params.subscribe(
      (params: Params) => {
        this.EventsScheduleService.getEvent(+params['id']) 
          .subscribe(
            (data: Event) => {
              this.editedEvent = data;
            })
      })
  }

  sendEdit() {
    console.log(this.editedEvent);
    const body = JSON.stringify(this.editedEvent);

    this.EventsScheduleService.editEvent(body, this.editedEvent.id) 
      .subscribe(
        (data) => {
          console.log(data);
        });

    this.Router.navigateByUrl('/event/' + this.editedEvent.id); 
  }

  deleteEvent() {
    this.EventsScheduleService.deleteEvent(this.editedEvent.id).subscribe(); 
    this.Router.navigateByUrl('/schedule');
  }

  parseJsonDate(jsonDateString) {
    return moment(jsonDateString).format("YYYY-MM-DD HH:mm");
  }

}
