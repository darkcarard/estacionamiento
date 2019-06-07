package co.com.ceiba.adn.estacionamiento.infraestructura.adapter.repository;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.ceiba.adn.estacionamiento.dominio.entity.Vehiculo;
import co.com.ceiba.adn.estacionamiento.dominio.port.VehiculoRepository;
import co.com.ceiba.adn.estacionamiento.infraestructura.adapter.mapper.VehiculoMapper;

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
	public void save(Vehiculo vehiculo) {	
		vehiculoRepository.save(vehiculoMapper.toEntity(vehiculo));
	}

}
