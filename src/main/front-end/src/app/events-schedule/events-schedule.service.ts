import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from "moment";


@Injectable({
  providedIn: 'root'
})
export class EventsScheduleService {

  private eventURL: string;
  private header;

  constructor(private Http: HttpClient) {
   this.eventURL = 'http://localhost:8080/events/'; 
   this.header = { headers: new HttpHeaders().set('Content-Type', 'application/json')};
  }

  addEvent(event) {
    return this.Http.post(this.eventURL, event, this.header);
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

  parseJsonDate(jsonDateString) {
    return moment(jsonDateString).format("YYYY-MM-DD HH:mm");
  }
}
