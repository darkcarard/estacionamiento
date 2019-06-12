package co.com.ceiba.dna.parking.infraestructure.adapter.mapper;

import org.springframework.stereotype.Component;

import co.com.ceiba.dna.parking.domain.entity.Vehicle;
import co.com.ceiba.dna.parking.infraestructure.adapter.entity.VehicleEntity;

@Component
public final class VehicleMapper {
	
	public VehicleEntity toEntity(Vehicle vehicle) {
		
		VehicleEntity vehicleEntity = new VehicleEntity();
		vehicleEntity.setCylinderCapacity(vehicle.getCylinderCapacity());
		vehicleEntity.setLicensePlate(vehicle.getLicensePlate());
		vehicleEntity.setTipo(vehicle.getVehicleType());
		
		return vehicleEntity;
	}
	
	public Vehicle toDomain(VehicleEntity vehicleEntity) {
		
		Vehicle vehicle = new Vehicle();
		vehicle.setLicensePlate(vehicleEntity.getLicensePlate());
		vehicle.setCylinderCapacity(vehicleEntity.getCylinderCapacity());		
		vehicle.setVehicleType(vehicleEntity.getTipo());
		
		return vehicle;
	}
}
