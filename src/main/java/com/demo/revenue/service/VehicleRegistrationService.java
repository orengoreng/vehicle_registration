package com.demo.revenue.service;

import java.util.List;

import com.demo.revenue.entity.VehicleRegistration;

public interface VehicleRegistrationService {

	VehicleRegistration save(VehicleRegistration person);

	VehicleRegistration get(Long id);

	List<VehicleRegistration> getAll();

	List<VehicleRegistration> getRegistrationsByPersonId(Long id);

	void update(VehicleRegistration body) throws Exception;

}
