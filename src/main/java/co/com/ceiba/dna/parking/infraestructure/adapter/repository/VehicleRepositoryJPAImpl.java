package co.com.ceiba.dna.parking.infraestructure.adapter.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.ceiba.dna.parking.domain.entity.Vehicle;
import co.com.ceiba.dna.parking.domain.repository.VehicleRepository;
import co.com.ceiba.dna.parking.infraestructure.adapter.mapper.VehicleMapper;

@Transactional
public class VehicleRepositoryJPAImpl implements VehicleRepository {

	@Autowired
	private VehicleRepositoryJPA vehicleRepository;

	@Override
	public void save(Vehicle vehicle) {	
		vehicleRepository.save(VehicleMapper.toEntity(vehicle));
	}

	@Override
	public List<Vehicle> findAll() {
		return VehicleMapper.toDomain(vehicleRepository.findAll());
	}

}
