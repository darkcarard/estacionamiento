package co.com.ceiba.dna.parking.domain.repository;

import java.util.List;

import co.com.ceiba.dna.parking.domain.entity.Vehicle;

public interface VehicleRepository {
	
	public void save(Vehicle vehicle);
	
	public List<Vehicle> findAll(); 

}
