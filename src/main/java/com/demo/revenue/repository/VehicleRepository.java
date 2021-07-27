package com.demo.revenue.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.revenue.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
