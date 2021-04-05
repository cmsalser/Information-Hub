import { Component, OnInit } from '@angular/core';
import { Thread } from '../../models/thread.model';
import { Router } from "@angular/router";
import { ForumService } from '../forum.service';
import { TopicForum } from '../../models/topicForum.model';
import { TopicForumService } from '../topic-forum.service';

@Component({
  selector: 'app-thread-add',
  templateUrl: './thread-add.component.html',
  styleUrls: ['./thread-add.component.css']
})
export class ThreadAddComponent implements OnInit {
  topics: TopicForum[] = [];
  newThread = {
    accountID: "",
    title: "",
    description: "",
    anonymous: false,
    stickied: false,
    forumID: "",
  };

  constructor(private ForumService: ForumService, private TopicForumService: TopicForumService, private Router: Router) { }

  ngOnInit(): void {
    this.newThread.accountID = JSON.parse(localStorage.getItem('user'))['data'].id;
    this.TopicForumService.getTopics()
    .subscribe(
      (topics: any[]) => {
        this.topics = topics;
      });
  }

  createThread() {
    const body = JSON.stringify(this.newThread);
    console.log(body);
    this.ForumService.addThread(body)
      .subscribe(
        (data: Thread) => {
          console.log(data);
          this.Router.navigateByUrl('/thread/' + data.threadID);
        })
  }
}