import { Component, OnInit } from '@angular/core';
import { FaqService } from './faq.service';

@Component({
  selector: 'app-faq',
  templateUrl: './faq.component.html',
  styleUrls: ['./faq.component.css']
})
export class FaqComponent implements OnInit {
  faqs = [];

  constructor(private FaqService: FaqService) { }

  ngOnInit(): void {
    this.FaqService.getFAQ()
      .subscribe(
        (faqs: any[]) => {
          this.faqs = faqs;
        }
      )
  }

}
