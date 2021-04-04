import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class EventsScheduleService {

  private eventURL: string;

  constructor(private Http: HttpClient) { 
   this.eventURL = 'http://localhost:8080/event/'; //backend?
  }

  addEvent(description, eventId) {
    console.log(description + " " + eventId)
  }

  getEvent(eventId) {
    return this.Http.get(this.eventURL + eventId);
  }

  getEvents() {
    return this.Http.get(this.eventURL);
  }

  deleteEvent(eventId) {
    return this.Http.delete(this.eventURL + eventId);
  }

  editEvent(description, eventId) {
    return this.Http.patch(this.eventURL + eventId, description);
  }

}
