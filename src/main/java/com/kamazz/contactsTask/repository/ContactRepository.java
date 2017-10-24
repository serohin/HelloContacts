package com.kamazz.contactsTask.repository;

import com.kamazz.contactsTask.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ContactRepository extends JpaRepository<Contact,Long> {
}
