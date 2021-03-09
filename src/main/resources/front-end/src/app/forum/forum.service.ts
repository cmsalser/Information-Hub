import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ForumService {

  constructor(private Http: HttpClient) { }

  getThread(id) {
    return this.Http.get('https://jsonplaceholder.typicode.com/posts/' + id);
  }

  getThreads() {
    return this.Http.get('https://jsonplaceholder.typicode.com/posts');
  }

  deleteThread(id) {
    return this.Http.delete('https://jsonplaceholder.typicode.com/posts/' + id);
  }

  editThread(body, id) {
    return this.Http.patch('https://jsonplaceholder.typicode.com/posts/' + id, body);
  }

  addThread(body, id) {
    console.log(body + " " + id)
  }

  getPosts(id) {
    return this.Http.get('https://jsonplaceholder.typicode.com/comments?postId=' + id);
  }
  
  getPostById(id) {
    return this.Http.get('https://jsonplaceholder.typicode.com/comments/' + id);
  }

  deletePost(id) {
    return this.Http.delete('https://jsonplaceholder.typicode.com/comments/' + id);
  }

  editPost(body, id) {
    return this.Http.patch('https://jsonplaceholder.typicode.com/comments/' + id, body);
  }
}
