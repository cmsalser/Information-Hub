import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
}) 
export class FaqService {

  constructor(private http: HttpClient) { }

  getFAQ(){
    return this.http.get('https://jsonplaceholder.typicode.com/posts');
  }

  getFaqByID(id) {
    return this.http.get('https://jsonplaceholder.typicode.com/posts/' + id);
  }

  editFaq(body, id) {
    return this.http.patch('https://jsonplaceholder.typicode.com/posts/' + id, body);
  }

  deleteFaq(id) {
    return this.http.delete('https://jsonplaceholder.typicode.com/posts/' + id);
  }
}
