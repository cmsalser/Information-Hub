import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ForumService {
  private threadURL: string;
  private postsURL: string;

  constructor(private Http: HttpClient) {
    this.threadURL = 'http://localhost:8080/thread/';
    this.postsURL = 'http://localhost:8080/post';
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
    return this.Http.put(this.threadURL + id, body);
  }

  addThread(body, id) {
    return this.Http.post(this.threadURL + id, body);
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