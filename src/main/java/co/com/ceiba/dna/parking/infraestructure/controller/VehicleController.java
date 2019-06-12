package co.com.ceiba.dna.parking.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.dna.parking.application.command.CreateVehicleCommandHandler;
import co.com.ceiba.dna.parking.domain.entity.Vehicle;

@RestController
@RequestMapping("/vehiculos")
public class VehicleController {

	private CreateVehicleCommandHandler createVehicleCommandHandler;

	@Autowired
	public VehicleController(CreateVehicleCommandHandler createVehicleCommandHandler) {
		this.createVehicleCommandHandler = createVehicleCommandHandler;
	}

	@PostMapping
	public void saveVehicle(@RequestBody Vehicle vehicle) {
		createVehicleCommandHandler.handler(vehicle);
	}
	
}
