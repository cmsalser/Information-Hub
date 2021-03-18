import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Faq } from '../models/faq.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FaqService {

  private faqURL: string;

  constructor(private http: HttpClient) {
    this.faqURL = 'http://localhost:8080/FAQ';
  }

  // public findAll(): Observable<Faq[]> {
    // return this.http.get<Faq[]>(this.faqURL);
  public findAll(): Observable<Object> {
    return this.http.get(this.faqURL);
  }

  public get(id: string): Observable<Object> {
    return this.http.get(this.faqURL + '/' + id);
  }

  public save(faq: Faq) {
    return this.http.post<Faq>(this.faqURL, faq)
  }

  // public update(id: string, faq: Faq) {
  //   return this.http.put(this.faqURL + '/' + id, faq)
  // }

  public delete(id: string) {
    return this.http.delete(this.faqURL + '/' + id)
  }

  // constructor(private http: HttpClient) { }

  // getFAQ(){
  //   return this.http.get('https://jsonplaceholder.typicode.com/posts');
  // }

  // getFaqByID(id) {
  //   return this.http.get('https://jsonplaceholder.typicode.com/posts/' + id);
  // }
}

