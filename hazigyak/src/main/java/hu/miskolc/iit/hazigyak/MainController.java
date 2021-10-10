package hu.miskolc.iit.hazigyak;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/carsaloon")
public class MainController {
	
	private final CarsalonService carsalonservice;
	
	public MainController(CarsalonService carsalonservice) {
		super();
		this.carsalonservice = carsalonservice;
	}
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	List<CarsalonDto> AllCars(){
		return carsalonservice.findAll();
	}
	@PostMapping(path = "")
	public void newCar(@RequestBody @Valid CarsalonDto carsalonDto) {
		carsalonservice.save(carsalonDto);
	}
	@PutMapping(path = "/")
	public void replaceCar(@RequestBody  CarsalonDto carsalonDto) {
		carsalonservice.save(carsalonDto);
	}
	@DeleteMapping(path = "/{id}")
	public void deleteCar(@PathVariable("id") String id) {

		}
}
