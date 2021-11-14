package hu.me.iit.webapps.db.controller;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import hu.me.iit.webapps.db.service.People;

public class PeopleCreateDto {
	
	public PeopleCreateDto(People people) {
		this.id = people.getId();
		this.name = people.getName();
		this.age = people.getAge();
	}
	
	public PeopleCreateDto() {
		
	}
	private Long id;
	@NotEmpty
	private String name;
	@Size(min=18)
	private int age;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public People toPeople() {
		return new People(null,age,name);
	}
	
}
