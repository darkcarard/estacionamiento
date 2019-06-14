package co.com.ceiba.dna.parking.infraestructure.adapter.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import co.com.ceiba.dna.parking.domain.entity.VehicleTypeEnum;

@Entity
@Table(name = "vehiculo")
public class VehicleEntity {

	@Id
	private String licensePlate;

	private int cylinderCapacity;

	@Enumerated(EnumType.STRING)
	private VehicleTypeEnum vehicleType;

	@OneToMany(mappedBy = "vehicle")
	private List<TicketEntity> tickets;
	
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

	public List<TicketEntity> getTickets() {
		return this.tickets;
	}

	public void setTickets(List<TicketEntity> tickets) {
		this.tickets = tickets;
	}
}
