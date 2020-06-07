package com.example.demo.dao;

import java.util.List;
import java.util.UUID;

import com.example.demo.model.Person;
import com.sun.el.stream.Optional;

public interface PersonDao {

	int InsertPerson(UUID id,Person person);
	
	default int InsertPerson(Person person) {
		UUID id = UUID.randomUUID();
		return InsertPerson(id, person);
	}
	List<Person> selectAllPeople();
	
	java.util.Optional<Person> selectPersonById(UUID id);
	
	int deletePersonByID(UUID id);
	int updatePersonById(UUID id, Person person);
}
