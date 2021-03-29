import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class EventsScheduleService {

  private EventURL: string;

  constructor(private Http: HttpClient) { 
    this.EventURL = 'https://jsonplaceholder.typicode.com/event/';
  }

  addEvent(description, eventId) {
    console.log(description + " " + eventId)
  }



}
