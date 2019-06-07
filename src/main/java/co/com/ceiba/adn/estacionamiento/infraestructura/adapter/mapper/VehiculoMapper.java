package co.com.ceiba.adn.estacionamiento.infraestructura.adapter.mapper;

import org.springframework.stereotype.Component;

import co.com.ceiba.adn.estacionamiento.dominio.entity.TipoVehiculo;
import co.com.ceiba.adn.estacionamiento.dominio.entity.Vehiculo;
import co.com.ceiba.adn.estacionamiento.infraestructura.adapter.entity.TipoVehiculoEntity;
import co.com.ceiba.adn.estacionamiento.infraestructura.adapter.entity.VehiculoEntity;

@Component
public final class VehiculoMapper {
	
	public VehiculoEntity toEntity(Vehiculo vehiculo) {
		
		VehiculoEntity vehiculoEntity = new VehiculoEntity();
		vehiculoEntity.setCilindraje(vehiculo.getCilindraje());
		vehiculoEntity.setPlaca(vehiculo.getPlaca());
		
		TipoVehiculoEntity tipoVehiculoEntity = new TipoVehiculoEntity();
		tipoVehiculoEntity.setId(vehiculo.getTipo().getId());
		tipoVehiculoEntity.setNombre(vehiculo.getTipo().getNombre());
		tipoVehiculoEntity.setValorHora(vehiculo.getTipo().getValorHora());
		tipoVehiculoEntity.setValorDia(vehiculo.getTipo().getValorDia());
		tipoVehiculoEntity.setCantidadMaxima(vehiculo.getTipo().getCantidadMaxima());
		
		vehiculoEntity.setTipo(tipoVehiculoEntity);
		
		return vehiculoEntity;
	}
	
	public Vehiculo toDomain(VehiculoEntity vehiculoEntity) {
		
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setPlaca(vehiculoEntity.getPlaca());
		vehiculo.setCilindraje(vehiculoEntity.getCilindraje());
		
		TipoVehiculo tipoVehiculo = new TipoVehiculo();
		tipoVehiculo.setId(vehiculoEntity.getTipo().getId());
		tipoVehiculo.setNombre(vehiculoEntity.getTipo().getNombre());
		tipoVehiculo.setValorHora(vehiculoEntity.getTipo().getValorHora());
		tipoVehiculo.setValorDia(vehiculoEntity.getTipo().getValorDia());
		tipoVehiculo.setCantidadMaxima(vehiculoEntity.getTipo().getCantidadMaxima());
		
		vehiculo.setTipo(tipoVehiculo);
		
		return vehiculo;
	}

}
