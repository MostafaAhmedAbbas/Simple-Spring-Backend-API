package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;

@Repository("FakeDao")
public class FakePersonAccessService implements PersonDao {

	private static List<Person> DB = new ArrayList<Person>();
	
	@Override
	public int InsertPerson(UUID id, Person person) {
		// TODO Auto-generated method stub
		DB.add(new Person(id, person.getName()));
		return 1;
	}
	@Override
	public List<Person> selectAllPeople() {
		
		return DB;
	}

	@Override
	public int deletePersonByID(UUID id) {
		Optional<Person> person =selectPersonById(id);
		if(person.isEmpty()) {
			return 0;
		}
		DB.remove(person.get());
		return 1;
	}
	@Override
	public Optional<Person> selectPersonById(UUID id) {
		// TODO Auto-generated method stub
		return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
	}
	@Override
	public int updatePersonById(UUID id, Person person) {
		// TODO Auto-generated method stub
		return selectPersonById(id)
				.map(p -> {
					int indexToDelete = DB.indexOf(p);
					if(indexToDelete >= 0) {
						DB.set(indexToDelete, new Person(id, person.getName()));
						return 1;
					}
					return 0;
		})
				.orElse(0);
	}


}
