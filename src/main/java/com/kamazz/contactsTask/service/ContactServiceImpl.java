package com.kamazz.contactsTask.service;


import com.kamazz.contactsTask.entity.Contact;
import com.kamazz.contactsTask.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
@CacheConfig(cacheNames = {"cache1"})
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepository;

    @Override
    public List<Contact> getContactsListNotMatchRegex(String regex) {
        List<Contact> listAllContacts = getAllContacts();
        return listAllContacts.parallelStream()
                    .unordered()
                    .filter(contact ->!(contact.getName().matches(regex)))
                    .collect(Collectors.toList());
    }

    @Cacheable
    private List<Contact> getAllContacts(){
        return contactRepository.findAll();
    }
}
