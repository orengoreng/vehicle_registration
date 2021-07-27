package com.demo.revenue.exception;

import lombok.Data;

@Data
public class ResourceNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	private ErrorMessage errMesage;

}
