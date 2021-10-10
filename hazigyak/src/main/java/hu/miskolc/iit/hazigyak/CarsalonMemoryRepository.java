package hu.miskolc.iit.hazigyak;

import java.util.ArrayList;
import java.util.List;

public class CarsalonMemoryRepository implements CarsalonRepository {
	
	private final List<CarsalonDto> carsalon = new ArrayList<>();
	
	private int findCarsalonById(int id) {
        int found = -1;
        for (int i = 0; i < carsalon.size(); i++) {
            if (carsalon.get(i).getId() == id ) {
                found = i;
                break;
            }
        }
        return found;
    }
	
	@Override
	public List<CarsalonDto> findAll() {
		return carsalon;
	}

	@Override
	public CarsalonDto getById(String id) {
		return null;
	}

	@Override
	public Long save(CarsalonDto carsalonDto) {
		int found = findCarsalonById(carsalonDto.getId());
		
		if(found != -1) {
			CarsalonDto foundcar = carsalon.get(found);
			foundcar.setAjtokszama(carsalonDto.getAjtokszama());
			foundcar.setFerohelyekszama(carsalonDto.getFerohelyekszama());
			foundcar.setGyartasiIdo(carsalonDto.getGyartasiIdo());
			foundcar.setGyarto(carsalonDto.getGyarto());
			foundcar.setKivitel(carsalonDto.getKivitel());
			foundcar.setModell(carsalonDto.getModell());
			foundcar.setRendszam(carsalonDto.getRendszam());
			foundcar.setSzin(carsalonDto.getSzin());
			foundcar.setUzemanyagtipus(carsalonDto.getUzemanyagtipus());
			foundcar.setValtotipus(carsalonDto.getValtotipus());
		}else {
			carsalon.add(carsalonDto);
		}
		return null;
	}

	@Override
	public void deleteById(int id) {
		
		int found = findCarsalonById(id);
		
		if(found != -1) {
			carsalon.remove(found);
		}
		
	}

}
