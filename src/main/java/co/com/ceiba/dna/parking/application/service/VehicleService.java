package co.com.ceiba.dna.parking.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.com.ceiba.dna.parking.domain.entity.Vehicle;
import co.com.ceiba.dna.parking.domain.repository.VehicleRepository;

@Service
public class VehicleService {

	private VehicleRepository vehicleRepository;

	public VehicleService(VehicleRepository vehicleRepository) {
		this.vehicleRepository = vehicleRepository;
	}

	public List<Vehicle> findAllVehicles() {
		return vehicleRepository.findAllVehicles();
	}

	public void saveVehicle(Vehicle vehicle) {
		vehicleRepository.save(vehicle);
	}

}
