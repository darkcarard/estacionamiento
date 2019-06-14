package co.com.ceiba.dna.parking.infraestructure.adapter.repository;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.ceiba.dna.parking.domain.entity.Vehicle;
import co.com.ceiba.dna.parking.domain.repository.VehicleRepository;
import co.com.ceiba.dna.parking.infraestructure.adapter.mapper.VehicleMapper;

public class VehicleRepositoryJPAImpl implements VehicleRepository {

	@Autowired
	private VehicleRepositoryJPA vehicleRepository;

	@Override
	public void save(Vehicle vehicle) {	
		vehicleRepository.save(VehicleMapper.toEntity(vehicle));
	}

}
