package com.kamazz.contactsTask.service;

import com.kamazz.contactsTask.repository.ContactRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContactServiceImplTest {
    @Autowired
    ContactService service;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void cachingGetAllContacts() throws Exception {
        ContactRepository mockRepository = Mockito.mock(ContactRepository.class);
        service.setContactRepository(mockRepository);
        service.getAllContacts();
        service.getAllContacts();
        service.getAllContacts();
        Mockito.verify(mockRepository, Mockito.times(1)).findAll();
    }

}

