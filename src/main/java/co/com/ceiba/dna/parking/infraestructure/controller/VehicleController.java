package co.com.ceiba.dna.parking.infraestructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.dna.parking.application.service.VehicleService;
import co.com.ceiba.dna.parking.domain.entity.Vehicle;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8762"})
@RestController
@RequestMapping("/vehiculos")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@PostMapping
	public void saveVehicle(@RequestBody Vehicle vehicle) {
		vehicleService.saveVehicle(vehicle);
	}

	@GetMapping
	public ResponseEntity<List<Vehicle>> findAllVehicles() {
		List<Vehicle> vehicles = vehicleService.findAllVehicles();
		return new ResponseEntity<>(vehicles, HttpStatus.OK);
	}
}
