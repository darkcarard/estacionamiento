package co.com.ceiba.dna.parking.infraestructure.adapter.mapper;

import org.springframework.stereotype.Component;

import co.com.ceiba.dna.parking.domain.entity.Vehicle;
import co.com.ceiba.dna.parking.infraestructure.adapter.entity.VehicleEntity;

@Component
public final class VehicleMapper {
	
	private VehicleMapper () {
		
	}
	
	public static VehicleEntity toEntity(Vehicle vehicle) {
		
		VehicleEntity vehicleEntity = new VehicleEntity();
		vehicleEntity.setCylinderCapacity(vehicle.getCylinderCapacity());
		vehicleEntity.setLicensePlate(vehicle.getLicensePlate());
		vehicleEntity.setVehicleType(vehicle.getVehicleType());
		
		return vehicleEntity;
	}
	
	public static Vehicle toDomain(VehicleEntity vehicleEntity) {
		
		Vehicle vehicle = new Vehicle();
		vehicle.setLicensePlate(vehicleEntity.getLicensePlate());
		vehicle.setCylinderCapacity(vehicleEntity.getCylinderCapacity());		
		vehicle.setVehicleType(vehicleEntity.getVehicleType());
		
		return vehicle;
	}
}
