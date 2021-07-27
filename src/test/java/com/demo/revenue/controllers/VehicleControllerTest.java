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

import com.demo.revenue.model.Vehicle;
import com.demo.revenue.service.PersonService;
import com.demo.revenue.service.VehicleRegistrationService;
import com.demo.revenue.service.VehicleService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest({ VehicleApiController.class })
public class VehicleControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PersonService personService;

	@MockBean
	private VehicleRegistrationService regos;

	@MockBean
	private VehicleService vehicleService;

	@Test
	public void testSaveVehicle() throws Exception {
		// init data
		com.demo.revenue.entity.Vehicle vehicle = new com.demo.revenue.entity.Vehicle();
		vehicle.setId(new Long(1));
		vehicle.setModel("Toyota");

		when(vehicleService.save(Mockito.any(com.demo.revenue.entity.Vehicle.class)))
				.thenReturn(vehicle);
		mockMvc.perform(MockMvcRequestBuilders.post("/demo/vehicle")
				.content(asJsonString(new Vehicle("test", "Test", "test")))
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
