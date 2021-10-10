package hu.miskolc.iit.hazigyak;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CarsalonServiceImpl implements CarsalonService {
	
	private final CarsalonRepository carsalonRepository;
	
	public CarsalonServiceImpl(CarsalonRepository carsalonRepository) {
		super();
		this.carsalonRepository = carsalonRepository;
	}
	
	@Override
	public List<CarsalonDto> findAll() {
		return carsalonRepository.findAll();
	}

	@Override
	public CarsalonDto getById(String id) {
		return carsalonRepository.getById(id);
	}

	@Override
	public Long save(CarsalonDto carsalonDto) {
		return carsalonRepository.save(carsalonDto);
	}

	@Override
	public void deleteById(int id) {
		carsalonRepository.deleteById(id);
		
	}

}
