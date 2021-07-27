package com.demo.revenue.service;

import com.demo.revenue.entity.Person;

public interface PersonService {

	public Person save(Person person);

	public Person get(Long id) throws Exception;
}
