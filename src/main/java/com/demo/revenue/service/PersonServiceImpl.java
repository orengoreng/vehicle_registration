package com.demo.revenue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.revenue.entity.Person;
import com.demo.revenue.exception.ResourceNotFoundException;
import com.demo.revenue.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Override
	public Person save(Person person) {
		return personRepository.save(person);
	}

	@Override
	public Person get(Long id) throws ResourceNotFoundException {
		Person person = personRepository.getOne(id);
		if (null == person) {
			throw new ResourceNotFoundException();
		}
		return person;
	}

}
