package hu.miskolc.iit.hazigyak;

import java.util.List;


public interface CarsalonService {
	List<CarsalonDto> findAll();
	CarsalonDto getById(String id);
	Long save(CarsalonDto carsalonDto);
	void deleteById(int id);
}
