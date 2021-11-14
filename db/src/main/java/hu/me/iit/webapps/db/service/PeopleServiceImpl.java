package hu.me.iit.webapps.db.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import hu.me.iit.webapps.db.repository.People;
import hu.me.iit.webapps.db.repository.PeopleRepository;

@Service
public class PeopleServiceImpl implements PeopleService {

	private final PeopleRepository peoplerepository;
	
	
	
	public PeopleServiceImpl(PeopleRepository peoplerepository) {
		this.peoplerepository = peoplerepository;
	}



	@Override
	public Iterable<People> getAllPeople() {
		List<People> rv = new ArrayList<People>();
		for (hu.me.iit.webapps.db.repository.People people : peoplerepository.findAll()) {
			rv.add(new People(people));
		}
		return rv;
	}
	public Iterable<People> getAllPeople2(){
		return StreamSupport.stream(peoplerepository.findAll().spliterator(), false).map(People::new).collect(Collectors.toList());
	}

	@Override
	public hu.me.iit.webapps.db.service.People create(hu.me.iit.webapps.db.service.People people) {
		return new hu.me.iit.webapps.db.service.People(peoplerepository.save(people.toEntity()));
	}
}
