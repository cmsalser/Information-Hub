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

  constructor(private FaqService: FaqService, private Route: ActivatedRoute, private Router: Router) { }

  ngOnInit(): void {
    this.Route.params.subscribe(
      (params: Params) => {
        this.FaqService.getFaqByID(+params['id'])
          .subscribe(
            (data: Faq) => {
              this.faq = data;
            })
      })
  }

  sendEdit() {
    console.log(this.faq);
    const body = JSON.stringify(this.faq);

    this.FaqService.editFaq(body, this.faq.id)
      .subscribe(
        (data) => {
          console.log(data);
        });

    this.Router.navigateByUrl('/faq');
  }

  deleteFaq() {
    this.FaqService.deleteFaq(this.faq.id);
    console.log("Faq id: " + this.faq.id + " deleted");
    this.Router.navigateByUrl('/faq');
  }
}
