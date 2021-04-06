import { Component, OnInit } from '@angular/core';
import { Thread } from '../../models/thread.model';
import { Post } from '../../models/post.model';
import { ActivatedRoute, Params, Router} from "@angular/router";
import { ForumService } from '../forum.service';
import { AuthService } from '../../auth/auth.service';

@Component({
  selector: 'app-thread',
  templateUrl: './thread.component.html',
  styleUrls: ['./thread.component.css']
})
export class ThreadComponent implements OnInit {
  thread = {} as Thread;
  posts: Post[] = [];

  constructor(private ForumService: ForumService, private Route: ActivatedRoute, private Router: Router, private AuthService: AuthService) { }

  ngOnInit(): void {
    this.Route.params.subscribe(
      (params: Params) => {
        this.ForumService.getThread(+params['id'])
        .subscribe(
          (data: Thread) => {
            this.thread = data;
          });
          this.ForumService.getPostsByThread(+params['id'])
          .subscribe(
            (resp) => {
              this.posts = resp['data'];
            });
      });
  }

  upvotePost(id) {
    let user = JSON.parse(localStorage.getItem('user')).id;
    this.ForumService.upvotePost(user, id).subscribe();
    window.location.reload();
    console.log(this.posts);
  }

  isVisable() {
    return this.AuthService.isAdmin();
  }
}