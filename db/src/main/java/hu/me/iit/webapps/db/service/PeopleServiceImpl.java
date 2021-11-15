package hu.me.iit.webapps.db.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import hu.me.iit.webapps.db.controller.PeopleDto;
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
			rv.add(new hu.me.iit.webapps.db.service.People(people));
		}
		return rv;
	}

	public Iterable<People> getAllPeople2() {
		return StreamSupport.stream(peoplerepository.findAll().spliterator(), false).map(People::new)
				.collect(Collectors.toList());
	}

	@Override
	public People create(hu.me.iit.webapps.db.service.People people) {
		return new People(peoplerepository.save(people.toEntity()));
	}

	@Override
	public void delete(Long id) {
		try {
			peoplerepository.deleteById(id);
		}catch(EmptyResultDataAccessException ex) {
			throw new NoSuchEntityException(id);
		}

	}
	@Override
	public People getByid(Long id) {
		Optional<hu.me.iit.webapps.db.repository.People> optioanalPeople = peoplerepository.findById(id);
		if (optioanalPeople.isEmpty()) {
			throw new NoSuchEntityException(id);
		}
		return new People(optioanalPeople.get());
	}

	@Override
	public void save(People people) {
		Optional<hu.me.iit.webapps.db.repository.People> optioanalPeople = peoplerepository.findById(people.getId());
		if (optioanalPeople.isEmpty()) {
			throw new NoSuchEntityException(people.getId());
		}
		peoplerepository.save(people.toEntity());
	}

	@Override
	public Iterable<? extends People> findByAgeGreaterThan(int age){
		return StreamSupport.stream(peoplerepository.findAll().spliterator(), false).map(People::new)
				.collect(Collectors.toList());
	}
}
