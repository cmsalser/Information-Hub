import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from "@angular/router";
import { ForumService } from '../forum.service';
import { Post } from '../../models/post.model';

@Component({
  selector: 'app-post-edit',
  templateUrl: './post-edit.component.html',
  styleUrls: ['./post-edit.component.css']
})
export class PostEditComponent implements OnInit {
  editedPost = {} as Post;

  constructor(private ForumService: ForumService, private Route: ActivatedRoute, private Router: Router) { }

  ngOnInit(): void {
    this.Route.params.subscribe(
      (params: Params) => {
        this.ForumService.getPostById(+params['id'])
          .subscribe(
            (data: Post) => {
              this.editedPost = data;
            })
      })
  }

  sendEdit() {
    const body = JSON.stringify(this.editedPost);

    this.ForumService.editPost(body)
      .subscribe();

    this.Router.navigateByUrl('/thread/' + this.editedPost.thread.threadID);
  }

  deletePost() {
    this.ForumService.deletePost(this.editedPost.id).subscribe();
    this.Router.navigateByUrl('/thread/' + this.editedPost.thread.threadID);
  }
}