package hu.me.iit.webapps.db.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.me.iit.webapps.db.service.People;
import hu.me.iit.webapps.db.service.PeopleService;

@RestController
@RequestMapping("/people")
public class PeopleController {

	private final PeopleService peopleservice;
	
	public PeopleController(PeopleService peopleservice) {
		this.peopleservice = peopleservice;
	}



	@GetMapping
	Iterable<PeopleDto> getAllPeople(){
		List<PeopleDto> peopleDtoList = new ArrayList<>();
		for (People people : peopleservice.getAllPeople()) {
			peopleDtoList.add(new PeopleDto(people));
		}
		return peopleDtoList;
		
	}
	@PostMapping(consumes = "application/json")
	PeopleDto save(@RequestBody @Valid PeopleCreateDto peopleCreateDto){
		
		return new PeopleDto(peopleservice.create(peopleCreateDto.toPeople()));
		
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		peopleservice.delete(id);
	}
	@GetMapping("/{id}")
	public PeopleDto getById(@PathVariable("id") Long id) {
		return new PeopleDto(peopleservice.getByid(id));
		
	}
	@PutMapping
	public void save(@RequestBody @Valid PeopleDto peopleDto) {
		peopleservice.save(peopleDto.toPeople());
	}
	@GetMapping("/findByAge")
 	public Iterable<PeopleDto> findAdultPeople(@RequestParam("age") int age) {
		return peopleservice.findByAgeGreaterThan(age);
	}
}
