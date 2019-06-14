package co.com.ceiba.dna.parking.infraestructure.adapter.repository;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.ceiba.dna.parking.domain.entity.Vehicle;
import co.com.ceiba.dna.parking.domain.repository.VehicleRepository;
import co.com.ceiba.dna.parking.infraestructure.adapter.mapper.VehicleMapper;

public class VehicleRepositoryJPAImpl implements VehicleRepository {

	@Autowired
	private VehicleRepositoryJPA vehicleRepository;

	@Override
	public Vehicle save(Vehicle vehicle) {	
		return VehicleMapper.toDomain(vehicleRepository.save(VehicleMapper.toEntity(vehicle)));
	}

}
