import { Component, OnInit } from '@angular/core';
import { Thread } from '../../models/thread.model';
import { ActivatedRoute, Params, Router } from "@angular/router";
import { ForumService } from '../forum.service';

@Component({
  selector: 'app-thread-edit',
  templateUrl: './thread-edit.component.html',
  styleUrls: ['./thread-edit.component.css']
})
export class ThreadEditComponent implements OnInit {
  editedThread = {} as Thread;

  constructor(private ForumService: ForumService, private Route: ActivatedRoute, private Router: Router) { }

  ngOnInit(): void {
    this.Route.params.subscribe(
      (params: Params) => {
        this.ForumService.getThread(+params['id'])
          .subscribe(
            (data: Thread) => {
              this.editedThread = data;
            })
      })
  }

  sendEdit() {
    console.log(this.editedThread);
  }
}
