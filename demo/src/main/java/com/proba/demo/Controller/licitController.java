package com.proba.demo.Controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.proba.demo.Service.licitService;

@Controller
public class licitController {

	private final licitService licitService;

	public licitController(licitService licitService) {
		super();
		this.licitService = licitService;
	}
	@GetMapping("/licit/highest")
	public int highestLicit() {
	 return licitService.getHighest();	
	}
	
	@GetMapping("/licit/highest/{userId}")
	public int userHighestLicit(@PathVariable Long userId) {
		return licitService.getHighestForUser(userId);
	}
	
	@PostMapping
	public void saveNewLicit(@Valid @RequestBody saveLicitDto saveLicitDto) {
		licitService.saveNewLicit(saveLicitDto.getLicit(), saveLicitDto.getUserId());
	}
}
