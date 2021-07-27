package com.demo.revenue.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.revenue.entity.VehicleRegistration;
import com.demo.revenue.exception.ResourceNotFoundException;
import com.demo.revenue.repository.VehicleRegistrationRepository;

@Service
public class VehicleRegistrationServiceImpl implements VehicleRegistrationService {

	@Autowired
	private VehicleRegistrationRepository registrationRepository;

	@Override
	public VehicleRegistration save(VehicleRegistration registration) {
		return registrationRepository.save(registration);
	}

	@Override
	public VehicleRegistration get(Long id) {
		VehicleRegistration register = registrationRepository.getOne(id);
		return register;
	}

	@Override
	public List<VehicleRegistration> getAll() {
		return registrationRepository.findAll();
	}

	@Override
	public List<VehicleRegistration> getRegistrationsByPersonId(Long id) {
		List<VehicleRegistration> results = registrationRepository.findByOwnerId(id);
		return results;
	}

	public void update(VehicleRegistration body) throws ResourceNotFoundException {
		VehicleRegistration rego = registrationRepository.getOne(body.getId());
		if (null == rego) {
			throw new ResourceNotFoundException();
		}
		BeanUtils.copyProperties(body, rego);
		registrationRepository.save(rego);
	}

}
