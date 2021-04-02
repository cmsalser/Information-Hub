import { Component, OnInit } from '@angular/core';
import { Thread } from '../models/thread.model';
import { TopicForum } from '../models/topicForum.model';
import { TopicForumService } from './topic-forum.service';
import { ForumService } from './forum.service';
import { Router } from "@angular/router";


@Component({
  selector: 'app-forum',
  templateUrl: './forum.component.html',
  styleUrls: ['./forum.component.css']
})
export class ForumComponent implements OnInit {
  threads: Thread[] = [];
  topics: TopicForum[] = [];

  constructor(private ForumService: ForumService, private TopicForumService: TopicForumService, private router: Router) { }

  ngOnInit(): void {
    let user = localStorage.getItem("user");
    if (user == undefined || user == null) {
      this.router.navigateByUrl('/');
    } else {
      this.ForumService.getThreads()
        .subscribe(
          (threads: any[]) => {
            this.threads = threads;
          });
      this.TopicForumService.getTopics()
        .subscribe(
          (topics: any[]) => {
            this.topics = topics;
          });
    }
  }

  eventCheck(event, id) {
    console.log(event.checked);
    console.log(id);
  }

  searchByWord(event) {
    console.log(event.value);
  }
}
