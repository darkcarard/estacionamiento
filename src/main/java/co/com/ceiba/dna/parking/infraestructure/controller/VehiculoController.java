package co.com.ceiba.dna.parking.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.dna.parking.aplication.command.CreateVehicleCommandHandler;
import co.com.ceiba.dna.parking.domain.entity.Vehicle;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

	private CreateVehicleCommandHandler createVehiculoCommandHandler;

	@Autowired
	public VehiculoController(CreateVehicleCommandHandler createVehiculoCommandHandler) {
		this.createVehiculoCommandHandler = createVehiculoCommandHandler;
	}

	@PostMapping
	public void save(@RequestBody Vehicle vehiculo) {
		createVehiculoCommandHandler.handler(vehiculo);
	}
	
}
