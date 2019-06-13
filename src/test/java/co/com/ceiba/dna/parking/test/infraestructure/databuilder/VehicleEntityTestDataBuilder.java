package co.com.ceiba.dna.parking.test.infraestructure.databuilder;

import co.com.ceiba.dna.parking.domain.entity.VehicleTypeEnum;
import co.com.ceiba.dna.parking.infraestructure.adapter.entity.VehicleEntity;

public class VehicleEntityTestDataBuilder {
	
	private static final String DEFAULT_LICENSE_PLATE = "ABC123";
	private static final int DEFAULT_CYLINDER_CAPACITY = 1500;
	private static final VehicleTypeEnum DEFAULT_VEHICLE_TYPE = VehicleTypeEnum.CAR;
	
	private String licensePlate;
	private int cylinderCapacity;
	private VehicleTypeEnum vehicleType;
	
	public VehicleEntityTestDataBuilder() {
		licensePlate = DEFAULT_LICENSE_PLATE;
		cylinderCapacity = DEFAULT_CYLINDER_CAPACITY;
		vehicleType = DEFAULT_VEHICLE_TYPE;
	}
	
	public VehicleEntityTestDataBuilder withLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
		
		return this;
	}
	
	public VehicleEntityTestDataBuilder withCylinderCapacity(int cylinderCapacity) {
		this.cylinderCapacity = cylinderCapacity;
		
		return this;
	}
	
	public VehicleEntityTestDataBuilder withVehicleType(VehicleTypeEnum vehicleType) {
		this.vehicleType = vehicleType;
		
		return this;
	}
	
	public VehicleEntity build() {
		return new VehicleEntity(licensePlate, cylinderCapacity, vehicleType);
	}

}
