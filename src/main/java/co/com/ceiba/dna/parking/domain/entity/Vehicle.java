package co.com.ceiba.dna.parking.domain.entity;

import co.com.ceiba.dna.parking.domain.validator.ArgumentValidator;

public class Vehicle {

	private String licensePlate;
	private int cylinderCapacity;
	private VehicleTypeEnum vehicleType;
	
	public Vehicle() {
		
	}

	public Vehicle(String licensePlate, int cylinderCapacity, VehicleTypeEnum vehicleType) {
		
		ArgumentValidator.requiredValidation(licensePlate, "El número de placa es obligatorio");
		ArgumentValidator.greaterThanZeroValidation(cylinderCapacity, "El cilindraje no puede ser cero o negativo");
		ArgumentValidator.requiredValidation(vehicleType, "El tipo del vehículo es obligatorio");
		
		this.licensePlate = licensePlate;
		this.cylinderCapacity = cylinderCapacity;
		this.vehicleType = vehicleType;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public int getCylinderCapacity() {
		return cylinderCapacity;
	}

	public VehicleTypeEnum getVehicleType() {
		return vehicleType;
	}

}
