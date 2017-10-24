package com.kamazz.contactsTask.service;

import com.kamazz.contactsTask.entity.Contact;

import java.util.List;


public interface ContactService {
    List<Contact> getContactsListNotMatchRegex(String regex);
}
