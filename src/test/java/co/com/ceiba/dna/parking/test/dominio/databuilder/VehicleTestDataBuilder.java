package co.com.ceiba.dna.parking.test.dominio.databuilder;

import co.com.ceiba.dna.parking.domain.entity.VehicleTypeEnum;
import co.com.ceiba.dna.parking.domain.entity.Vehicle;

public class VehicleTestDataBuilder {
	
	private static final String DEFAULT_LICENSE_PLATE = "ABC123";
	private static final int DEFAULT_CYLINDER_CAPACITY = 1500;
	private static final VehicleTypeEnum DEFAULT_VEHICLE_TYPE = VehicleTypeEnum.CAR;
	
	private String licensePlate;
	private int cylinderCapacity;
	private VehicleTypeEnum vehicleType;
	
	public VehicleTestDataBuilder() {
		licensePlate = DEFAULT_LICENSE_PLATE;
		cylinderCapacity = DEFAULT_CYLINDER_CAPACITY;
		vehicleType = DEFAULT_VEHICLE_TYPE;
	}
	
	public VehicleTestDataBuilder withLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
		
		return this;
	}
	
	public VehicleTestDataBuilder withCylinderCapacity(int cylinderCapacity) {
		this.cylinderCapacity = cylinderCapacity;
		
		return this;
	}
	
	public VehicleTestDataBuilder withVehicleType(VehicleTypeEnum vehicleType) {
		this.vehicleType = vehicleType;
		
		return this;
	}
	
	public Vehicle build() {
		return new Vehicle(licensePlate, cylinderCapacity, vehicleType);
	}

}
