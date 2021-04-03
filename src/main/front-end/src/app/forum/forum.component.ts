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
    this.ForumService.getThreads()
        .subscribe(
          (threads: any[]) => {
            this.threads = threads;
          });
      this.TopicForumService.getTopics()
        .subscribe(
          (topics: any[]) => {
            this.topics = topics;
            let defaultTopic = new TopicForum(-1, "All");
            this.topics.push(defaultTopic);
          });
  }

  topicSelection(id) {
    if (id == -1) {
      this.ForumService.getThreads()
        .subscribe(
          (threads: any[]) => {
            this.threads = threads;
          });
    } else {
      this.ForumService.getThreadsByForum(id)
      .subscribe(
        (threadsByForum: any[]) => {
          this.threads = threadsByForum;
        });
    }
  }

  searchByWord(event) {
    if (event.value == "") {
      this.ForumService.getThreads()
        .subscribe(
          (threads: any[]) => {
            this.threads = threads;
          });
    } else {
      this.ForumService.searchThreads(event.value)
        .subscribe(
          (searchResult: any[]) => {
            this.threads = searchResult;
          });
    }
  }
}
