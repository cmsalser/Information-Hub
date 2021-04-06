import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { TopicForumService } from '../topic-forum.service';

@Component({
  selector: 'app-topic-add',
  templateUrl: './topic-add.component.html',
  styleUrls: ['./topic-add.component.css']
})
export class TopicAddComponent implements OnInit {
  newTopic = {
    title: ""
  };

  constructor(private TopicForumService: TopicForumService, private router: Router) { }

  ngOnInit(): void {
  }

  createTopic() {
    this.TopicForumService.postTopic(this.newTopic).subscribe();
    this.router.navigateByUrl('/forum');
  }
}
