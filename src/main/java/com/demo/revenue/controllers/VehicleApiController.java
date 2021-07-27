package com.demo.revenue.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;

import com.demo.revenue.model.Vehicle;
import com.demo.revenue.service.VehicleService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-25T02:12:24.601+10:00[Australia/Sydney]")

@Controller
@RequestMapping("${openapi.demoVehicleRegistration.base-path:/demo}")
public class VehicleApiController extends BaseApi implements VehicleApi {

	private final NativeWebRequest request;

	@Autowired
	private VehicleService vehicleService;

	@org.springframework.beans.factory.annotation.Autowired
	public VehicleApiController(NativeWebRequest request) {
		this.request = request;
	}

	@Override
	public Optional<NativeWebRequest> getRequest() {
		return Optional.ofNullable(request);
	}

	/**
	 * POST /vehicle : Add a vehicle information
	 *
	 * @param body Vehicle object to be saved (required)
	 * @return Success (status code 200) or Invalid input (status code 400) or
	 *         Server error (status code 500)
	 * @throws Exception
	 */
	@ApiOperation(value = "Add a vehicle information", nickname = "saveVehicle", notes = "", response = Object.class, tags = {
			"vehicle", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = Object.class),
			@ApiResponse(code = 400, message = "Invalid input"),
			@ApiResponse(code = 500, message = "Server error") })
	@RequestMapping(value = "/vehicle", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	public ResponseEntity<Object> saveVehicle(
			@ApiParam(value = "Vehicle object to be saved", required = true) @Valid @RequestBody Vehicle body)
			throws Exception {
		com.demo.revenue.entity.Vehicle person = this.convertObject(body,
				com.demo.revenue.entity.Vehicle.class);
		com.demo.revenue.entity.Vehicle saved = vehicleService.save(person);
		if (null == saved) {
			throw new Exception("unsuccesssful saving vehicle");
		}
		return new ResponseEntity<>(saved, HttpStatus.OK);

	}

}
