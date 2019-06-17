package co.com.ceiba.dna.parking.infraestructure.adapter.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.com.ceiba.dna.parking.domain.entity.Vehicle;
import co.com.ceiba.dna.parking.infraestructure.adapter.entity.VehicleEntity;

@Component
public final class VehicleMapper {

	private VehicleMapper() {

	}

	public static VehicleEntity toEntity(Vehicle vehicle) {
		return new VehicleEntity(vehicle.getLicensePlate(), vehicle.getCylinderCapacity(), vehicle.getVehicleType());
	}

	public static Vehicle toDomain(VehicleEntity vehicleEntity) {
		return new Vehicle(vehicleEntity.getLicensePlate(), vehicleEntity.getCylinderCapacity(),
				vehicleEntity.getVehicleType());
	}

	public static List<Vehicle> toDomain(List<VehicleEntity> vehicleEntities) {
		List<Vehicle> vehicles = new ArrayList<>();
		vehicleEntities.forEach(vehicleEntity -> {
			Vehicle vehicle = toDomain(vehicleEntity);
			vehicles.add(vehicle);
		});
		
		return vehicles;
	}
}
