import { Component, OnInit } from '@angular/core';
import { FaqService } from './faq.service';
import { AuthService } from '../auth/auth.service';
import { Faq } from '../models/faq.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-faq',
  templateUrl: './faq.component.html',
  styleUrls: ['./faq.component.css']
})
export class FaqComponent implements OnInit {
  faqs: Faq[] = [];

  constructor(private router: Router, private FaqService: FaqService, private AuthService: AuthService) { }

  ngOnInit(): void {
    this.FaqService.findAll().subscribe( (faqs: any[]) => {
      this.faqs = faqs;
    });
  }

  isAdmin() {
    return this.AuthService.adminStatus;
  }

  deleteFaq(id) {
    this.FaqService.delete(id).subscribe();
    this.faqs = this.faqs.filter(item => item.id != id);


    // this.FaqService.delete(id).subscribe((faqs: any[]) => {
    //     this.faqs = faqs;
    // });
    // .subscribe(this.fetchData());
  }

  // fetchData() {
  //   this.FaqService.findAll().subscribe((faqs: any[]) =>{
  //       this.faqs = faqs;
  //   });
  // }
}
