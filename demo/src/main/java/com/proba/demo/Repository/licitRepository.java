package com.proba.demo.Repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface licitRepository extends PagingAndSortingRepository<Licit, Long> {

	Optional<Licit> findTopByOrderByLicitDesc();

	Optional<Licit> findTopByUseridAndOrderByLicitDesc(Long userId);

}
