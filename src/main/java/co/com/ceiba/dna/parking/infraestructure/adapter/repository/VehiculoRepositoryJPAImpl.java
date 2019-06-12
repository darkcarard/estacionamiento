package co.com.ceiba.dna.parking.infraestructure.adapter.repository;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.ceiba.dna.parking.domain.entity.Vehicle;
import co.com.ceiba.dna.parking.domain.repository.VehiculoRepository;
import co.com.ceiba.dna.parking.infraestructure.adapter.mapper.VehiculoMapper;

public class VehiculoRepositoryJPAImpl implements VehiculoRepository {

	private VehiculoRepositoryJPA vehiculoRepository;
	private VehiculoMapper vehiculoMapper;
	
	public VehiculoRepositoryJPA getVehiculoRepository() {
		return vehiculoRepository;
	}

	@Autowired
	public void setVehiculoRepository(VehiculoRepositoryJPA vehiculoRepository) {
		this.vehiculoRepository = vehiculoRepository;
	}

	public VehiculoMapper getVehiculoMapper() {
		return vehiculoMapper;
	}

	@Autowired
	public void setVehiculoMapper(VehiculoMapper vehiculoMapper) {
		this.vehiculoMapper = vehiculoMapper;
	}

	@Override
	public void save(Vehicle vehiculo) {	
		vehiculoRepository.save(vehiculoMapper.toEntity(vehiculo));
	}

}
