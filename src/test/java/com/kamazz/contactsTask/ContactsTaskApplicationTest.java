package com.kamazz.contactsTask;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ContactsTaskApplicationTest {
    @Autowired
    private MockMvc mockMvc;
    @Before
    public void setUp() throws Exception {

    }
    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getListContactsByRegex() throws Exception {
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
