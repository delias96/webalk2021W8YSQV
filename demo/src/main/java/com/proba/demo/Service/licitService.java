package com.proba.demo.Service;

import org.springframework.stereotype.Service;

@Service
public interface licitService {

	int getHighest();

	int getHighestForUser(Long userId);

	void saveNewLicit(int licit,Long userId);

}
