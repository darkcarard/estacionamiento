package co.com.ceiba.dna.parking.domain.entity;

import java.util.List;

import co.com.ceiba.dna.parking.domain.validator.ArgumentValidator;
import co.com.ceiba.dna.parking.infraestructure.adapter.entity.TicketEntity;

public class Vehicle {

	private String licensePlate;
	private int cylinderCapacity;
	private VehicleTypeEnum vehicleType;
	private List<TicketEntity> tickets;
	
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

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public int getCylinderCapacity() {
		return cylinderCapacity;
	}

	public void setCylinderCapacity(int cylinderCapacity) {
		this.cylinderCapacity = cylinderCapacity;
	}

	public VehicleTypeEnum getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleTypeEnum vehicleType) {
		this.vehicleType = vehicleType;
	}

	public List<TicketEntity> getTickets() {
		return tickets;
	}

	public void setTickets(List<TicketEntity> tickets) {
		this.tickets = tickets;
	}	
}
