package com.kamazz.contactsTask.service;


import com.kamazz.contactsTask.entity.Contact;
import com.kamazz.contactsTask.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Transactional
@Service
@CacheConfig(cacheNames = "cache1")
public class ContactServiceImpl implements ContactService {

    public static final String EMPTY_INPUT = "";

    @Autowired
    ContactRepository contactRepository;

    @Override
    public List<Contact> getContactsListNotMatchRegex(String regex) {
        List<Contact> listAllContacts = getAllContacts();
        Pattern patternRegex = Pattern.compile(regex);
        Matcher matcher = patternRegex.matcher(EMPTY_INPUT);

        return listAllContacts.parallelStream()
                .unordered()
                .filter(contact -> !matcher.reset(contact.getName()).matches())
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Cacheable
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public void setContactRepository(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }
}
