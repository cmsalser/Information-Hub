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
    this.postsURL = 'http://localhost:8080/post';
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
    console.log(body);
    return this.Http.put(this.threadURL + id, body, this.header);
  }

  addThread(body): Observable<Object> {
    return this.Http.post(this.threadURL, body, this.header);
  }

  getPosts(id) {
    return this.Http.get('https://jsonplaceholder.typicode.com/comments?postId=' + id);
  }
  
  getPostById(id) {
    return this.Http.get(this.postsURL + id);
  }

  deletePost(id) {
    return this.Http.delete(this.postsURL + id);
  }

  editPost(body, id) {
    return this.Http.patch(this.postsURL + id, body);
  }
}