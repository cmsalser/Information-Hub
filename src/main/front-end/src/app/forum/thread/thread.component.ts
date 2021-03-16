import { Component, OnInit } from '@angular/core';
import { Thread } from '../../models/thread.model';
import { Post } from '../../models/post.model';
import { ActivatedRoute, Params, Router} from "@angular/router";
import { ForumService } from '../forum.service';

@Component({
  selector: 'app-thread',
  templateUrl: './thread.component.html',
  styleUrls: ['./thread.component.css']
})
export class ThreadComponent implements OnInit {
  thread = {} as Thread;
  posts: Post[] = [];

  constructor(private ForumService: ForumService, private Route: ActivatedRoute, private Router: Router) { }

  ngOnInit(): void {
    this.Route.params.subscribe(
      (params: Params) => {
        this.ForumService.getThread(+params['id'])
        .subscribe(
          (data: Thread) => {
            this.thread = data;
          })

          this.ForumService.getPosts(+params['id'])
          .subscribe(
            (comments: any[]) => {
              this.posts = comments;
            })
      })
  }
}