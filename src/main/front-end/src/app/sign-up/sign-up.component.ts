import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms';
import {UserService} from "../user/user.service";
import {CustomValidationService} from "../services/custom-validation.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})

export class SignUpComponent implements OnInit {


  constructor(private fb: FormBuilder, public userService: UserService, public customValidator: CustomValidationService, private router: Router) { }

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
      email: ['', [Validators.required, Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$"),
                   Validators.minLength(1)], this.customValidator.validateEmailNotTaken.bind(this.customValidator)],
      birthday: ['', [Validators.required], this.customValidator.validateDateOfBirth.bind(this.customValidator)]

    }, {
      validator: this.customValidator.passwordMatchValidator("password", "confirmPassword")
    })
  }



  onSubmit(): void {
    this.userService.register(this.userService.signUpForm.value)
      .subscribe(res => {
        res ? this.router.navigateByUrl('/') : this.router.navigateByUrl('/sign-up');
      });
  };

}
