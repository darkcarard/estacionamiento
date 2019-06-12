package co.com.ceiba.dna.parking.infraestructure.adapter.repository;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.ceiba.dna.parking.domain.entity.Vehicle;
import co.com.ceiba.dna.parking.domain.repository.VehiculoRepository;
import co.com.ceiba.dna.parking.infraestructure.adapter.mapper.VehicleMapper;

public class VehiculoRepositoryJPAImpl implements VehiculoRepository {

	private VehiculoRepositoryJPA vehiculoRepository;
	private VehicleMapper vehiculoMapper;

	@Autowired
	public void setVehiculoRepository(VehiculoRepositoryJPA vehiculoRepository) {
		this.vehiculoRepository = vehiculoRepository;
	}

	@Autowired
	public void setVehiculoMapper(VehicleMapper vehiculoMapper) {
		this.vehiculoMapper = vehiculoMapper;
	}

	@Override
	public void save(Vehicle vehiculo) {	
		vehiculoRepository.save(vehiculoMapper.toEntity(vehiculo));
	}

}
