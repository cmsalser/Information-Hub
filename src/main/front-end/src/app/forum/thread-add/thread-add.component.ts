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
  newThread = {
    accountID: "",
    title: "",
    description: "",
    anonymous: false,
    stickied: false,
    forumID: "",
  };

  constructor(private ForumService: ForumService, private Router: Router) { }

  ngOnInit(): void {
    this.newThread.accountID = JSON.parse(localStorage.getItem('user'))['data'].id;
  }

  createThread() {
    const body = JSON.stringify(this.newThread);
    this.ForumService.addThread(body)
      .subscribe(
        (data: Thread) => {
          console.log(data);
          this.Router.navigateByUrl('/thread/' + data.threadID);
        })
  }
}