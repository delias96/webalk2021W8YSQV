package hu.me.iit.webapps.db.service;

import java.util.List;

import hu.me.iit.webapps.db.controller.PeopleDto;

public interface PeopleService {
	Iterable<hu.me.iit.webapps.db.service.People> getAllPeople();
	People create(People people);
	void delete(Long id);
	People getByid(Long id);
	void save(People peole);
	Iterable<? extends People> findByAgeGreaterThan(int age);
}
