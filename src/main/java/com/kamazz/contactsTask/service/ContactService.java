package com.kamazz.contactsTask.service;

import com.kamazz.contactsTask.entity.Contact;
import com.kamazz.contactsTask.repository.ContactRepository;

import java.util.List;


public interface ContactService {
    List<Contact> getContactsListNotMatchRegex(String regex);
    void setContactRepository(ContactRepository mockRepository);
    List<Contact> getAllContacts();
}
