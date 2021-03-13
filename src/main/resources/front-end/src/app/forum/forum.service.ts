import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ForumService {
  private postsURL: string;
  private commentsURL: string;

  constructor(private Http: HttpClient) {
    this.postsURL = 'https://jsonplaceholder.typicode.com/posts/';
    this.commentsURL = 'https://jsonplaceholder.typicode.com/comments/';
   }

  getThread(id) {
    return this.Http.get(this.postsURL + id);
  }

  getThreads() {
    return this.Http.get(this.postsURL);
  }

  deleteThread(id) {
    return this.Http.delete(this.postsURL + id);
  }

  editThread(body, id) {
    return this.Http.patch(this.postsURL + id, body);
  }

  addThread(body, id) {
    console.log(body + " " + id)
  }

  getPosts(id) {
    return this.Http.get('https://jsonplaceholder.typicode.com/comments?postId=' + id);
  }
  
  getPostById(id) {
    return this.Http.get(this.commentsURL + id);
  }

  deletePost(id) {
    return this.Http.delete(this.commentsURL + id);
  }

  editPost(body, id) {
    return this.Http.patch(this.commentsURL + id, body);
  }
}
