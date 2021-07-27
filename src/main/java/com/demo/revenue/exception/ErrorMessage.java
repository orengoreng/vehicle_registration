package com.demo.revenue.exception;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ErrorMessage {

	private String message;
	private LocalDate date;
}
