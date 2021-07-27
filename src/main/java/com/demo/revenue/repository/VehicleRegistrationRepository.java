package com.demo.revenue.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.revenue.entity.VehicleRegistration;

public interface VehicleRegistrationRepository
		extends JpaRepository<VehicleRegistration, Long> {

	List<VehicleRegistration> findByOwnerId(Long Id);

}
