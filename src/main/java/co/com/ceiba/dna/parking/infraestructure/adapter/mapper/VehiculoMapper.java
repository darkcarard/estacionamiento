package co.com.ceiba.dna.parking.infraestructure.adapter.mapper;

import org.springframework.stereotype.Component;

import co.com.ceiba.dna.parking.domain.entity.Vehicle;
import co.com.ceiba.dna.parking.infraestructure.adapter.entity.VehicleEntity;

@Component
public final class VehiculoMapper {
	
	public VehicleEntity toEntity(Vehicle vehiculo) {
		
		VehicleEntity vehiculoEntity = new VehicleEntity();
		vehiculoEntity.setCylinderCapacity(vehiculo.getCylinderCapacity());
		vehiculoEntity.setPlaca(vehiculo.getPlaca());
		vehiculoEntity.setTipo(vehiculo.getTipo());
		
		return vehiculoEntity;
	}
	
	public Vehicle toDomain(VehicleEntity vehiculoEntity) {
		
		Vehicle vehiculo = new Vehicle();
		vehiculo.setPlaca(vehiculoEntity.getPlaca());
		vehiculo.setCylinderCapacity(vehiculoEntity.getCylinderCapacity());		
		vehiculo.setTipo(vehiculoEntity.getTipo());
		
		return vehiculo;
	}

}
