package org.webproject.controller;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.webproject.configuration.AppConfig;
import org.webproject.configuration.WebMvcConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, WebMvcConfig.class})
@WebAppConfiguration
public class BidControllerTest {
	private MockMvc mockMvc;
	 
    @Autowired
    private BidController bidServiceMock;
 
    @Autowired
    private WebApplicationContext webApplicationContext;
 
    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    public void testBidController() throws Exception {
    	 mockMvc.perform(get("/"))
         .andExpect(status().isOk())
         .andExpect(view().name("Home"))
         .andExpect(forwardedUrl("/WEB-INF/views/Home.jsp"))
         .andExpect(model().attribute("productDone", notNullValue()))
    	 .andExpect(model().attribute("sessions", notNullValue()));
    }
}
