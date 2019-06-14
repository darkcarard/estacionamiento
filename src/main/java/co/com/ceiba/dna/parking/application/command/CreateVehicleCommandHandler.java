package co.com.ceiba.dna.parking.application.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ceiba.dna.parking.domain.entity.Vehicle;
import co.com.ceiba.dna.parking.domain.repository.VehicleRepository;

@Component
public class CreateVehicleCommandHandler {

	
	private VehicleRepository vehicleRepository;

	@Autowired
	public CreateVehicleCommandHandler(VehicleRepository vehicleRepository) {
		this.vehicleRepository = vehicleRepository;
	}

	public void handler(Vehicle vehiculo) {
		vehicleRepository.save(vehiculo);
	}
	
}
