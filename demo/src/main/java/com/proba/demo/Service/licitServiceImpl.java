package com.proba.demo.Service;

import java.util.Optional;

import com.proba.demo.Repository.*;

public class licitServiceImpl implements licitService {

	private final licitRepository licitRepository;
	
	public licitServiceImpl(licitRepository licitRepository) {
	    this.licitRepository = licitRepository;
	}
	
	@Override
	public int getHighest() {
		Optional<Licit> result =  licitRepository.findTopByOrderByLicitDesc();
		if(result.isEmpty()) return 0; 
		return result.get().getLicit();
	}

	@Override
	public int getHighestForUser(Long userId) {
		Optional<Licit> result = licitRepository.findTopByUseridAndOrderByLicitDesc(userId);
		if(result.isEmpty()) return 0; 
		return result.get().getLicit();
	}

	@Override
	public void saveNewLicit(int licit, Long userId) {
		licitRepository.save(new Licit(licit,userId));
	}

}
