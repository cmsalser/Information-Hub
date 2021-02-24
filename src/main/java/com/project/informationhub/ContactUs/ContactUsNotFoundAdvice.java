package com.project.informationhub.ContactUs;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class ContactUsNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(ContactUsNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String ContactUsNotFoundHandler(ContactUsNotFoundException ex) {
    return ex.getMessage();
  }
}