package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;

@Service
public class PersonSevice {
	
	private final PersonDao personDao;
	
	@Autowired
	public PersonSevice(@Qualifier("FakeDao") PersonDao personDao) {
		super();
		this.personDao = personDao;
	}

	public int addPerson(Person person) {
		return personDao.InsertPerson(person);
	}
	public List<Person> getAllPeople(){
		return personDao.selectAllPeople();
	}
	
	public Optional<Person> getPersonById(UUID id){
		return personDao.selectPersonById(id);
	}
	
	public int deletePerson(UUID id) {
		return personDao.deletePersonByID(id);
	}
	public int updatePerson(UUID id, Person person) {
		return personDao.updatePersonById(id, person);
	}

}
