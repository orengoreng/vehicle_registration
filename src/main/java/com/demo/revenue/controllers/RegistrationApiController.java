package com.demo.revenue.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;

import com.demo.revenue.entity.Person;
import com.demo.revenue.entity.Vehicle;
import com.demo.revenue.exception.ResourceNotFoundException;
import com.demo.revenue.model.Registration;
import com.demo.revenue.service.VehicleRegistrationService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-25T21:18:01.178+10:00[Australia/Sydney]")

@Controller
@RequestMapping("${openapi.demoVehicleRegistration.base-path:/demo}")
public class RegistrationApiController extends BaseApi implements RegistrationApi {

	private final NativeWebRequest request;

	@Autowired
	private VehicleRegistrationService registrationService;

	@org.springframework.beans.factory.annotation.Autowired
	public RegistrationApiController(NativeWebRequest request) {
		this.request = request;
	}

	@Override
	public Optional<NativeWebRequest> getRequest() {
		return Optional.ofNullable(request);
	}

	/**
	 * PUT /register_vehicle : Update register vehicle
	 *
	 * @param body Get Vehicle Registration (required)
	 * @return Success (status code 200) or Invalid input (status code 400) or
	 *         Resource not found (status code 404)
	 * @throws Exception
	 */
	@ApiOperation(value = "Update vehicle registration", nickname = "putRegisterVehicle", notes = "", response = Object.class, tags = {
			"register vehicle", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = Object.class),
			@ApiResponse(code = 400, message = "Invalid input"),
			@ApiResponse(code = 404, message = "Resource not found") })
	@RequestMapping(value = "/registration", produces = {
			"application/json" }, consumes = {
					"application/json" }, method = RequestMethod.PUT)
	public ResponseEntity<Object> putRegisterVehicle(
			@ApiParam(value = "Get Vehicle Registration", required = true) @Valid @RequestBody Registration body)
			throws Exception {
		registrationService.update(this.convertToEntity(body));
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * POST /registration : Register vehicle
	 *
	 * @param body Register a Vehicle (required)
	 * @return Success (status code 200) or Invalid input (status code 400)
	 * @throws Exception
	 */
	@ApiOperation(value = "Register vehicle", nickname = "saveRegisterVehicle", notes = "", response = Object.class, tags = {
			"register vehicle", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = Object.class),
			@ApiResponse(code = 400, message = "Invalid input") })
	@RequestMapping(value = "/registration", produces = {
			"application/json" }, consumes = {
					"application/json" }, method = RequestMethod.POST)
	public ResponseEntity<Object> saveRegisterVehicle(
			@ApiParam(value = "Register a Vehicle", required = true) @Valid @RequestBody Registration body)
			throws Exception {
		com.demo.revenue.entity.VehicleRegistration saved = registrationService
				.save(this.convertToEntity(body));
		if (null == saved) {
			throw new Exception("unsuccesssful saving registration");
		}
		com.demo.revenue.dto.VehicleRegistration registrationDto = this
				.convertObject(saved, com.demo.revenue.dto.VehicleRegistration.class);
		return new ResponseEntity<>(registrationDto, HttpStatus.OK);
	}

	/**
	 * GET /registration : Get all vehicle registration
	 *
	 * @return Success (status code 200)
	 * @throws ResourceNotFoundException
	 */
	@ApiOperation(value = "Get all vehicle registration", nickname = "getRegisterVehicle", notes = "", response = Registration.class, responseContainer = "List", tags = {
			"register vehicle", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = Registration.class, responseContainer = "List") })
	@RequestMapping(value = "/registration", produces = {
			"application/json" }, method = RequestMethod.GET)
	public ResponseEntity<List<com.demo.revenue.dto.VehicleRegistration>> getRegisterVehicle()
			throws ResourceNotFoundException {
		List<com.demo.revenue.entity.VehicleRegistration> regos = registrationService
				.getAll();
		if (null == regos) {
			throw new ResourceNotFoundException();
		}
		List<com.demo.revenue.dto.VehicleRegistration> results = regos.stream()
				.map(u -> this.convertObject(u,
						com.demo.revenue.dto.VehicleRegistration.class))
				.collect(Collectors.toList());
		return new ResponseEntity<>(results, HttpStatus.OK);
	}

	/**
	 * GET /registration/person/{id} : Get all vehicle registration by person id
	 *
	 * @param id Get person Id (required)
	 * @return Success (status code 200)
	 * @throws ResourceNotFoundException
	 */
	@ApiOperation(value = "Get all vehicle registration by person id", nickname = "getRegisterVehicleByPersonId", notes = "", response = Registration.class, responseContainer = "List", tags = {
			"register vehicle", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = Registration.class, responseContainer = "List"),
			@ApiResponse(code = 404, message = "Resource not found") })
	@RequestMapping(value = "/registration/person/{id}", produces = {
			"application/json" }, method = RequestMethod.GET)
	public ResponseEntity<List<com.demo.revenue.dto.VehicleRegistration>> getRegisterVehicleByPersonId(
			@ApiParam(value = "Get person Id", required = true) @PathVariable("id") Long id)
			throws ResourceNotFoundException {
		List<com.demo.revenue.entity.VehicleRegistration> regos = registrationService
				.getRegistrationsByPersonId(id);
		if (null == regos) {
			throw new ResourceNotFoundException();
		}
		List<com.demo.revenue.dto.VehicleRegistration> results = regos.stream()
				.map(u -> this.convertObject(u,
						com.demo.revenue.dto.VehicleRegistration.class))
				.collect(Collectors.toList());
		return new ResponseEntity<>(results, HttpStatus.OK);

	}

	private com.demo.revenue.entity.VehicleRegistration convertToEntity(
			Registration body) {
		Person person = new Person();
		com.demo.revenue.entity.VehicleRegistration registration = new com.demo.revenue.entity.VehicleRegistration();
		if (null != body.getPersonId()) {
			person.setId(body.getPersonId());
			registration.setOwner(person);
		}
		Vehicle vehicle = new Vehicle();
		vehicle.setId(body.getVehicleId());
		registration.setVehicle(vehicle);
		registration.setId(body.getId());
		return registration;
	}

}
