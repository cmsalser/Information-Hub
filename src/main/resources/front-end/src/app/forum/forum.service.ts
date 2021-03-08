import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ForumService {

  constructor(private Http: HttpClient) { }

  getThreads() {
    return this.Http.get('https://jsonplaceholder.typicode.com/posts');
  }

  getThread(id) {
    return this.Http.get('https://jsonplaceholder.typicode.com/posts/' + id);
  }

  getComments(id) {
    return this.Http.get('https://jsonplaceholder.typicode.com/comments?postId=' + id);
  }
}
