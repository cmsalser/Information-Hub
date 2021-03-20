import { Component, OnInit } from '@angular/core';
import {FormBuilder} from '@angular/forms';
import {UserService} from "../user/user.service";

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})

export class SignUpComponent implements OnInit {
  //add option to input gender when "not listed" selected
  // gender: string[] = ['Female','Male', 'Transgender', 'Non-binary','Intersex', 'Not Listed: please provide details', 'Prefer not to say',''];

  // user: User = new User("firstname", "lastname", "email", "username", "pass", new Date(1998, 1, 1))

  constructor(private fb: FormBuilder, public userService: UserService) { }

  ngOnInit(): void {
    this.initializeSignUp();
  }
  initializeSignUp(): void {
    this.userService.signUpForm = this.fb.group({
      firstname: [''],
      lastname: [''],
      username: [''],
      password: [''],
      // confirmPassword: [''],
      // selectGender: '',
      email: [''],
      birthday: ['']
      // conditions: this.fb.group({
      //   privacyPolicy: false,
      //   termsAndConditions: false
      // })
    })
  }

  // onSubmit(): void {
  //   this.userService.register(this.userService.signUpForm.value).subscribe()
  // }

  onSubmit(): void {
    this.userService.register(this.userService.signUpForm.value)
      .subscribe();
  };
// need to fix this drop down selection
//   selectGender(event): void {
//       this.signUpForm.patchValue({
//         selectGender: event.target.value
//       });
//   }
}
