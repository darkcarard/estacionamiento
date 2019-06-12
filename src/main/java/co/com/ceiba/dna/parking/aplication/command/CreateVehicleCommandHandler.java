package co.com.ceiba.dna.parking.aplication.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ceiba.dna.parking.domain.entity.Vehicle;
import co.com.ceiba.dna.parking.domain.repository.VehiculoRepository;

@Component
public class CreateVehicleCommandHandler {

	private VehiculoRepository repository;

	@Autowired
	public CreateVehicleCommandHandler(VehiculoRepository repository) {
		this.repository = repository;
	}
	
	public void handler(Vehicle vehiculo) {
		
		repository.save(vehiculo);
	}
	
}
