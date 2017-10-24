package com.kamazz.contactsTask.repository;

import com.kamazz.contactsTask.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Component
@Repository
public interface ContactRepository extends JpaRepository<Contact,Long> {
}
