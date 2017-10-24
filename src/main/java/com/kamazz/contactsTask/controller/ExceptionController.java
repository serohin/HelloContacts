package com.kamazz.contactsTask.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    protected ResponseEntity handleInvalidRequestMethod() {
        return new ResponseEntity("Request method not supported", HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler({MissingServletRequestParameterException.class})
    protected ResponseEntity handleInvaliRequestGet() {
        return new ResponseEntity("Required String parameter is not present", HttpStatus.BAD_REQUEST);
    }


}
