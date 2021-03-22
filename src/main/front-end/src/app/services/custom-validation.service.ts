import { Injectable } from '@angular/core';
import {AbstractControl, FormGroup} from "@angular/forms";
import { HttpClient } from "@angular/common/http";
import { map} from "rxjs/operators";
import {UserService} from "../user/user.service";
import {Observable} from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class CustomValidationService {

  constructor(private http: HttpClient, private userService: UserService) { }

  passwordMatchValidator(password: string, confirmPassword: string) {
    return (formGroup: FormGroup) => {
      const passwordControl = formGroup.controls[password];
      const confirmPasswordControl = formGroup.controls[confirmPassword];

      if (!passwordControl || !confirmPasswordControl) {
        return null;
      }

      if (confirmPasswordControl.errors && !confirmPasswordControl.errors.passwordMismatch) {
        return null;
      }

      if (passwordControl.value !== confirmPasswordControl.value) {
        confirmPasswordControl.setErrors({ passwordMismatch: true });
      } else {
        confirmPasswordControl.setErrors(null);
      }
    };
  }

  validateUsernameNotTaken(control: AbstractControl) {
    return this.userService.checkUsernameExists(control.value).pipe(
      map(res => {
        return res ? {usernameTaken: true} : null;
      })
    );
  }
}
