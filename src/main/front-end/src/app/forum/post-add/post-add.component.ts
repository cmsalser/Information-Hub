import { Component, OnInit } from '@angular/core';
import { Thread } from '../../models/thread.model';
import { Post } from '../../models/post.model';
import { ActivatedRoute, Params, Router} from "@angular/router";
import { ForumService } from '../forum.service';

@Component({
  selector: 'app-post-add',
  templateUrl: './post-add.component.html',
  styleUrls: ['./post-add.component.css']
})
export class PostAddComponent implements OnInit {
  thread = {} as Thread;
  newPost = {
    threadID: -1,
    title: "",
    description: "",
    stickied: false,
    anonymous: false
  }
  constructor(private ForumService: ForumService, private Route: ActivatedRoute, private Router: Router) { }

  ngOnInit(): void {
    this.Route.params.subscribe(
      (params: Params) => {
        this.newPost.threadID = +params['id'];
        this.ForumService.getThread(+params['id'])
        .subscribe(
          (data: Thread) => {
            this.thread = data;
          });
      });
  }

  createPost() {
    const body = JSON.stringify(this.newPost);
    console.log(body);
    this.ForumService.addPost(body)
    .subscribe(
      (data) => {
        console.log(data);
      });
      this.Router.navigateByUrl('/thread/' + this.newPost.threadID);
  }
}
