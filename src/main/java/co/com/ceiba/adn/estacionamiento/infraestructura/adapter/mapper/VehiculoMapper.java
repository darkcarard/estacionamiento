package co.com.ceiba.adn.estacionamiento.infraestructura.adapter.mapper;

import org.springframework.stereotype.Component;

import co.com.ceiba.adn.estacionamiento.dominio.entity.Vehiculo;
import co.com.ceiba.adn.estacionamiento.infraestructura.adapter.entity.VehiculoEntity;

@Component
public final class VehiculoMapper {
	
	public VehiculoEntity toEntity(Vehiculo vehiculo) {
		
		VehiculoEntity vehiculoEntity = new VehiculoEntity();
		vehiculoEntity.setCilindraje(vehiculo.getCilindraje());
		vehiculoEntity.setPlaca(vehiculo.getPlaca());
		vehiculoEntity.setTipo(vehiculo.getTipo());
		
		return vehiculoEntity;
	}
	
	public Vehiculo toDomain(VehiculoEntity vehiculoEntity) {
		
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setPlaca(vehiculoEntity.getPlaca());
		vehiculo.setCilindraje(vehiculoEntity.getCilindraje());		
		vehiculo.setTipo(vehiculoEntity.getTipo());
		
		return vehiculo;
	}

}
