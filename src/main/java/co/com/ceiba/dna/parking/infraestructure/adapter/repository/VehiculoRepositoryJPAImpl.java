package co.com.ceiba.dna.parking.infraestructure.adapter.repository;

import org.springframework.stereotype.Repository;

import co.com.ceiba.dna.parking.domain.entity.Vehicle;
import co.com.ceiba.dna.parking.domain.repository.VehicleRepository;
import co.com.ceiba.dna.parking.infraestructure.adapter.mapper.VehicleMapper;

@Repository
public class VehiculoRepositoryJPAImpl implements VehicleRepository {

	private VehiculoRepositoryJPA vehicleRepository;

	@Override
	public void save(Vehicle vehicle) {	
		vehicleRepository.save(VehicleMapper.toEntity(vehicle));
	}

}
