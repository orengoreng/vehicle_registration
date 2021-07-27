package com.demo.revenue.dto;

import lombok.Data;

@Data
public class VehicleRegistration {

	private Long id;

	private Person owner;

	private Vehicle vehicle;

}
