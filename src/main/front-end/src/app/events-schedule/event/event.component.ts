import { Component, OnInit } from '@angular/core';
import { Event } from '../../models/event.model';
import { ActivatedRoute, Params } from "@angular/router";
import { EventsScheduleService } from '../events-schedule.service';
import * as moment from "moment";


@Component({
  selector: 'app-event',
  templateUrl: './event.component.html',
  styleUrls: ['./event.component.css']
})
export class EventComponent implements OnInit {

  event = {} as Event;
  events : Event[];

  constructor( private EventsScheduleService: EventsScheduleService, private Route: ActivatedRoute) { }

  ngOnInit(): void {
    this.Route.params.subscribe(
      (params: Params) => {
        this.EventsScheduleService.getEvent(+params['id']).subscribe( 
          (data: Event) => {
            this.event = data;
          })
      })
  }

  parseJsonDate(jsonDateString) {
    return moment(jsonDateString).format("YYYY-MM-DD HH:mm");
  }
}
