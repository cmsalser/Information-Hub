import { Component, OnInit } from '@angular/core';
import { Thread } from '../models/thread.model';
import { ForumService } from './forum.service';
import { Router } from "@angular/router";


@Component({
  selector: 'app-forum',
  templateUrl: './forum.component.html',
  styleUrls: ['./forum.component.css']
})
export class ForumComponent implements OnInit {
  threads: Thread[] = [];

  constructor(private ForumService: ForumService, private router: Router) { }

  ngOnInit(): void {
    let user = localStorage.getItem("user");
    if(user == undefined || user == null) {
      this.router.navigateByUrl('/');
    } else {
      this.ForumService.getThreads()
        .subscribe(
          (threads: any[]) => {
            this.threads = threads;
          })
    }
  }

}
