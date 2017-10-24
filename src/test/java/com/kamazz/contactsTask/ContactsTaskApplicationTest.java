package com.kamazz.contactsTask;

import com.kamazz.contactsTask.controller.ContactController;
import com.kamazz.contactsTask.entity.Contact;
import com.kamazz.contactsTask.service.ContactServiceImpl;
import com.kamazz.contactsTask.validator.RequestParamValidatorImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ContactController.class)
@RunWith(SpringRunner.class)
public class ContactsTaskApplicationTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ContactServiceImpl contactService;
    @MockBean
    private RequestParamValidatorImpl paramValidator;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getListContactsByRegex() throws Exception {
        Contact abbot = new Contact((long) 9, "Abbott");
        List<Contact> contactsNotMatchRegex = Arrays.asList(abbot);

        given(this.contactService
                .getContactsListNotMatchRegex("^.*[aelni].*$"))
                .willReturn(contactsNotMatchRegex);

        this.mockMvc.perform(get("/hello/contacts?nameFilter=^.*[aelni].*$")
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$[0].name").value("Abbott"));
    }
    @Test
    public void handleInvaliRequestGet()throws Exception {
        this.mockMvc.perform(get("/hello/contacts")
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("Required String parameter is not present")));
    }
    @Test
    public void handleInvalidRequestMethod()throws Exception{
        this.mockMvc.perform(put("/hello/contacts?nameFilter")
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isMethodNotAllowed())
                .andExpect(content().string(containsString("Request method not supported")));
    }

}
