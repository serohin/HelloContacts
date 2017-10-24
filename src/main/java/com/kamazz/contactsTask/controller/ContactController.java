package com.kamazz.contactsTask.controller;

import com.kamazz.contactsTask.service.ContactService;
import com.kamazz.contactsTask.validator.RequestParamValidatorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/hello")
public class ContactController {
    @Autowired
    private ContactService contactService;
    @Autowired
    private RequestParamValidatorImpl paramValidator;

    @GetMapping(value = "/contacts",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity getListContactsByRegex(@RequestParam("nameFilter") String nameFilter) {
        Map<String, String> errorMap = paramValidator.validate(nameFilter);
        if (errorMap.isEmpty()) {
            return new ResponseEntity(contactService.getContactsListNotMatchRegex(nameFilter),HttpStatus.OK);
        }
        return new ResponseEntity(errorMap.get("requestParam"),HttpStatus.BAD_REQUEST);
    }
}
