import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth/auth.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  menuItems = [
    {linkId: 1, linkName: 'Home'},
    {linkId: 2, linkName: 'About Us'},
    {linkId: 3, linkName: 'Information and Support'},
    {linkId: 4, linkName: 'Discussion Forum'},
    {linkId: 5, linkName: 'Calendar and Events'},
    {linkId: 6, linkName: 'FAQ'},
    {linkId: 7, linkName: 'Contact Us'},
  ]

  constructor(private AuthService: AuthService) { }

  ngOnInit(): void {
  }

  authenticated() {
    return this.AuthService.authenticated;
  }
}
