package com.demo.revenue.controllers;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class BaseApi {

	private final ThreadLocal<ObjectMapper> threadLocal = ThreadLocal.withInitial(() -> {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		return mapper;
	});

	protected <T> T convertObject(Object o, Class<T> ref) {
		return (T) threadLocal.get().convertValue(o, ref);
	}

}
