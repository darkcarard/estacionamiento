package co.com.ceiba.dna.parking.infraestructure.adapter.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import co.com.ceiba.dna.parking.domain.entity.VehicleTypeEnum;

@Entity
@Table(name = "vehicle")
public class VehicleEntity {

	@Id
	private String licensePlate;

	private int cylinderCapacity;

	@Enumerated(EnumType.STRING)
	private VehicleTypeEnum vehicleType;
	
	public VehicleEntity() {
		
	}

	public VehicleEntity(String licensePlate, int cylinderCapacity, VehicleTypeEnum vehicleType) {
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
