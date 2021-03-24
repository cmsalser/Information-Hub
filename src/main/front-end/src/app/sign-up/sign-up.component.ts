import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms';
import {UserService} from "../user/user.service";
import {CustomValidationService} from "../services/custom-validation.service";

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})

export class SignUpComponent implements OnInit {
  //add option to input gender when "not listed" selected
  // gender: string[] = ['Female','Male', 'Transgender', 'Non-binary','Intersex', 'Not Listed: please provide details', 'Prefer not to say',''];

  // user: User = new User("firstname", "lastname", "email", "username", "pass", new Date(1998, 1, 1))

  constructor(private fb: FormBuilder, public userService: UserService, public customValidator: CustomValidationService) { }

  ngOnInit(): void {
    this.initializeSignUp();
  }
  initializeSignUp(): void {
    this.userService.signUpForm = this.fb.group({
      firstname: ['', [Validators.required]],
      lastname: ['', [Validators.required]],
      username: ['', [Validators.required, Validators.minLength(3)], this.customValidator.validateUsernameNotTaken.bind(this.customValidator)],
      password: ['', [Validators.required, Validators.minLength(8)]],
      confirmPassword: ['', [Validators.required]],
      // selectGender: '',
      email: ['', [Validators.required, Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$"),
                   Validators.minLength(1)], this.customValidator.validateEmailNotTaken.bind(this.customValidator)],
      birthday: ['', [Validators.required], this.customValidator.validateDateOfBirth.bind(this.customValidator)]
      // conditions: this.fb.group({
      //   privacyPolicy: false,
      //   termsAndConditions: false
      // })
    }, {
      validator: this.customValidator.passwordMatchValidator("password", "confirmPassword")
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
