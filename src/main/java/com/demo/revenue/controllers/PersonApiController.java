package com.demo.revenue.controllers;

import java.util.Optional;

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

import com.demo.revenue.model.Person;
import com.demo.revenue.service.PersonService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-25T02:12:24.601+10:00[Australia/Sydney]")

@Controller
@RequestMapping("${openapi.demoVehicleRegistration.base-path:/demo}")
public class PersonApiController extends BaseApi implements PersonApi {

	private final NativeWebRequest request;

	@Autowired
	private PersonService personService;

	@org.springframework.beans.factory.annotation.Autowired
	public PersonApiController(NativeWebRequest request) {
		this.request = request;
	}

	@Override
	public Optional<NativeWebRequest> getRequest() {
		return Optional.ofNullable(request);
	}

	/**
	 * POST /person : Add a person detail
	 *
	 * @param body Person object to be saved (required)
	 * @return Success (status code 200) or Invalid input (status code 400)
	 * @throws Exception
	 */
	@ApiOperation(value = "Add a person detail", nickname = "savePerson", notes = "", response = Object.class, tags = {
			"person", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = Object.class),
			@ApiResponse(code = 400, message = "Invalid input") })
	@RequestMapping(value = "/person", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	public ResponseEntity<Object> savePerson(
			@ApiParam(value = "Person object to be saved", required = true) @Valid @RequestBody Person body)
			throws Exception {
		com.demo.revenue.entity.Person person = this.convertObject(body,
				com.demo.revenue.entity.Person.class);
		com.demo.revenue.entity.Person saved = personService.save(person);
		if (null == saved) {
			throw new Exception("unsuccesssful saving person");
		}
		return new ResponseEntity<>(saved, HttpStatus.OK);
	}

	/**
	 * GET /person/{personId} : Add a person detail
	 *
	 * @param personId Get person Id (required)
	 * @return Success (status code 200) or Invalid input (status code 400) or
	 *         Server error (status code 500)
	 * @throws Exception
	 */
	@ApiOperation(value = "Add a person detail", nickname = "getPerson", notes = "", response = Object.class, tags = {
			"person", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = Object.class),
			@ApiResponse(code = 400, message = "Invalid input"),
			@ApiResponse(code = 500, message = "Server error") })
	@RequestMapping(value = "/person/{personId}", produces = {
			"application/json" }, method = RequestMethod.GET)
	public ResponseEntity<Object> getPerson(
			@ApiParam(value = "Get person Id", required = true) @PathVariable("personId") Long personId)
			throws Exception {
		com.demo.revenue.entity.Person person = personService.get(personId);
		com.demo.revenue.dto.Person result = this.convertObject(person,
				com.demo.revenue.dto.Person.class);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
