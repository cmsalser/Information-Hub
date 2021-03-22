import { Component, OnInit } from '@angular/core';
import { Thread } from '../../models/thread.model';
import { Router } from "@angular/router";
import { ForumService } from '../forum.service';

@Component({
  selector: 'app-thread-add',
  templateUrl: './thread-add.component.html',
  styleUrls: ['./thread-add.component.css']
})
export class ThreadAddComponent implements OnInit {
  newThread = {} as Thread;

  constructor(private ForumService: ForumService, private Router: Router) { }

  ngOnInit(): void {
  }

  createThread() {
    const body = JSON.stringify(this.newThread);
    this.ForumService.addThread(body, this.newThread.threadID);
    this.Router.navigateByUrl('/thread/' + this.newThread.threadID);
  }
}