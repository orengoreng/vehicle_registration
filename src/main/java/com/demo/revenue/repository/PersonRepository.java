package com.demo.revenue.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.revenue.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
