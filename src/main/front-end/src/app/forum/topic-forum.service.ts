import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TopicForumService {
  private topicURL: string;
  private header;

  constructor(private Http: HttpClient) { 
    this.topicURL = 'http://localhost:8080/topicforum/';
    this.header = { headers: new HttpHeaders().set('Content-Type', 'application/json')};
  }
  
  getTopics() {
    return this.Http.get(this.topicURL);
  }

  postTopic(body) {
    return this.Http.post(this.topicURL, body, this.header);
  }
}
