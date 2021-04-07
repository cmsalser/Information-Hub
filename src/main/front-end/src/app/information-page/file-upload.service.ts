import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const API_URL = "http://localhost:8080/information/";
const httpOptions = {
    headers: new HttpHeaders({
        'Content-Type': 'application/json'
    })
};

@Injectable({
  providedIn: 'root'
})
export class FileUploadService {

  constructor(private Http: HttpClient) { }

  uploadFile(file) {
    return this.Http.post(API_URL, file);
  }

  getAllFiles() {
    return this.Http.get(API_URL);
  }
  getFile(fileName) {
    return this.Http.get(API_URL + fileName, {responseType: 'blob'});
  }
}
