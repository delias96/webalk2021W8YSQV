package hu.me.iit.webapps.db.service;

import java.util.List;

public interface PeopleService {
	Iterable<People> getAllPeople();
	People create(People people);
}
