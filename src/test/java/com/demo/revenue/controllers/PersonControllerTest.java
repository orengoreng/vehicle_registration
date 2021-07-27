package com.demo.revenue.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.demo.revenue.model.Person;
import com.demo.revenue.service.PersonService;
import com.demo.revenue.service.VehicleRegistrationService;
import com.demo.revenue.service.VehicleService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest({ PersonApiController.class })
public class PersonControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PersonService personService;

	@MockBean
	private VehicleRegistrationService regos;

	@MockBean
	private VehicleService vehicle;

	@Test
	public void testSavePerson() throws Exception {
		// init data
		com.demo.revenue.entity.Person person = new com.demo.revenue.entity.Person();
		person.setId(new Long(1));
		person.setFirstname("test");
		person.setLastname("Test");

		when(personService.save(Mockito.any(com.demo.revenue.entity.Person.class)))
				.thenReturn(person);
		mockMvc.perform(MockMvcRequestBuilders.post("/demo/person")
				.content(asJsonString(new Person("test", "Test")))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(new Long(1)));
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
