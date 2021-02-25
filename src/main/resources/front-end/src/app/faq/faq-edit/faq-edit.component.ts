import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Params, Router} from "@angular/router";
import { Faq } from '../../models/faq.model';
import { FaqService } from '../faq.service';

@Component({
  selector: 'app-faq-edit',
  templateUrl: './faq-edit.component.html',
  styleUrls: ['./faq-edit.component.css']
})
export class FaqEditComponent implements OnInit {
  faq = {} as Faq;
  id: number;

  constructor(private FaqService: FaqService, private Route: ActivatedRoute, private Router: Router) { }

  ngOnInit(): void {
    this.Route.params.subscribe(
      (params: Params) => {
        this.id = +params['id'];
        this.FaqService.getFaqByID(this.id)
          .subscribe(
            (data: Faq) => {
              this.faq = data;
            })
      })
  }

}
