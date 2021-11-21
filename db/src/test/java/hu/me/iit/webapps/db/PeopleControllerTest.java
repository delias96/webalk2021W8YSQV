package hu.me.iit.webapps.db;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import hu.me.iit.webapps.db.repository.People;
import hu.me.iit.webapps.db.repository.PeopleRepository;

@SpringBootTest
@AutoConfigureMockMvc
class PeopleControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private PeopleRepository peopleRepository;

	@Test
	public void shouldNoMainPage() throws Exception{
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().is4xxClientError());
	}
	
	@Test
	public void shouldReturnPeople() throws Exception{
		//Given
		People people = new People(1L,12, "1");
		peopleRepository.save(people);
		//When,Then
		this.mockMvc.perform(get("/people")).andDo(print()).andExpect(status().isOk()).andExpect(content().string("[{\"id\":1,\"name\":\"1\",\"age\":12}]"));
	}

}
