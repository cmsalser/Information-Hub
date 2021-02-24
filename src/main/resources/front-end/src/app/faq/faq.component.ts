import { Component, OnInit } from '@angular/core';
import { FaqService } from './faq.service';
import { AuthService } from '../auth/auth.service';
import { Faq } from '../models/faq.model';

@Component({
  selector: 'app-faq',
  templateUrl: './faq.component.html',
  styleUrls: ['./faq.component.css']
})
export class FaqComponent implements OnInit {
  faqs: Faq[] = [];

  constructor(private FaqService: FaqService, private AuthService: AuthService) { }

  ngOnInit(): void {
    this.FaqService.getFAQ()
      .subscribe(
        (faqs: any[]) => {
          this.faqs = faqs;
        }
      )
  }

  isAdmin() {
    return this.AuthService.adminStatus;
  }

  deleteFaq(id) {
    this.faqs = this.faqs.filter(
        faq => faq.id !== id);
  }
}
