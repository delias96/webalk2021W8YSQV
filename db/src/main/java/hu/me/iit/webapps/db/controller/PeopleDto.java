package hu.me.iit.webapps.db.controller;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import hu.me.iit.webapps.db.service.People;

public class PeopleDto {
	
	public PeopleDto(People people) {
		this.id = people.getId();
		this.name = people.getName();
		this.age = people.getAge();
	}
	
	public PeopleDto() {
		
	}
	private Long id;
	@NotEmpty
	private String name;
	@Min(18)
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
        return new People(null, age, name);
    }
	
	
}
