import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ForumService {
  private threadURL: string;
  private postsURL: string;
  private header;

  constructor(private Http: HttpClient) {
    this.threadURL = 'http://localhost:8080/thread/';
    this.postsURL = 'http://localhost:8080/post/';
    this.header = { headers: new HttpHeaders().set('Content-Type', 'application/json')};
   }

  getThread(id) {
    return this.Http.get(this.threadURL + id);
  }

  getThreads() {
    return this.Http.get(this.threadURL);
  }

  deleteThread(id) {
    return this.Http.delete(this.threadURL + id);
  }

  editThread(body, id) {
    return this.Http.put(this.threadURL + id, body, this.header);
  }

  addThread(body): Observable<Object> {
    return this.Http.post(this.threadURL, body, this.header);
  }

  getPostsByThread(threadID) {
    return this.Http.get(this.postsURL + 'bythread/' + threadID);
  }
  
  getPostById(id) {
    return this.Http.get(this.postsURL + id);
  }

  deletePost(id) {
    return this.Http.delete(this.postsURL + id);
  }

  editPost(body) {
    return this.Http.put(this.postsURL, body, this.header);
  }
}