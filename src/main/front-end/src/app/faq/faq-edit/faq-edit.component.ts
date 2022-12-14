import { Component, OnInit } from '@angular/core';
import { FormGroup, NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { FaqService } from '../faq.service';

@Component({
  selector: 'app-faq-edit',
  templateUrl: './faq-edit.component.html',
  styleUrls: ['./faq-edit.component.css']
})
export class FaqEditComponent implements OnInit {



  faq: any = {};
  form: FormGroup;

  sub: Subscription;

  constructor(private route: ActivatedRoute, private router: Router, private FaqService: FaqService) { }

  ngOnInit(): void {




    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];

      if (id) {
        this.FaqService.get(id).subscribe((faq: any) => {
          if (faq) {
            this.faq = faq;

          } else {
            console.log(`Car with id '${id}' not found, returning to list`);
          }
        });
      }
    });
  }

  onSubmit() {
    this.FaqService.save(this.faq).subscribe(result => this.gotoFAQList());
  }

  gotoFAQList() {
    this.router.navigate(['/faq']);
  }

}
