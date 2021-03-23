import { Component, OnInit } from '@angular/core';
import { Thread } from '../models/thread.model';
import { ForumService } from './forum.service';

@Component({
  selector: 'app-forum',
  templateUrl: './forum.component.html',
  styleUrls: ['./forum.component.css']
})
export class ForumComponent implements OnInit {
  threads: Thread[] = [];

  constructor(private ForumService: ForumService) { }

  ngOnInit(): void {
    this.ForumService.getThreads()
      .subscribe(
        (threads: any[]) => {
          this.threads = threads;
        })
  }

}