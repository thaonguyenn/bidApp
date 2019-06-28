package org.webproject.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeClass;
import org.webproject.service.BidSessionsService;



public class BidSessionDaoTest {

	private MockMvc mockMvc;
	@Mock
	BidSessionsDao dao;
	
	@InjectMocks
	BidSessionsService service;

//	@InjectMocks
//	EmployeeServiceImpl employeeService;

	@BeforeClass
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders
                .standaloneSetup(service)
                .build();
	}
	@org.testng.annotations.Test
	public void test() {
		org.testng.Assert.assertNull(dao);
	}

}
