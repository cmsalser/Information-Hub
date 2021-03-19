import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})

export class SignUpComponent implements OnInit {
  //add option to input gender when "not listed" selected
  gender: string[] = ['Female','Male', 'Transgender', 'Non-binary','Intersex', 'Not Listed: please provide details', 'Prefer not to say',''];
  signUpForm: FormGroup;
  constructor(private fb: FormBuilder ) { }

  ngOnInit(): void {
    this.initializeSignUp();
  }
  initializeSignUp(): void {
    this.signUpForm = this.fb.group({
      firstName: 'First Name',
      LastName: 'Last Name',
      username: 'Username',
      password: 'Password',
      selectGender: '',
      conditions: this.fb.group({
        privacyPolicy: false,
        termsAndConditions: false
      }),
      email: 'email here'
    })
  }

  onSubmit(): void {
    console.log(this.signUpForm); 
  }
// need to fix this drop down selection 
  selectGender(event): void {
      this.signUpForm.patchValue({
        selectGender: event.target.value
      });
  } 


}
