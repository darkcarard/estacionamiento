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
	private VehicleTypeEnum tipo;

	@OneToMany(mappedBy = "vehicle")
	private List<TicketEntity> tickets;

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

	public VehicleTypeEnum getTipo() {
		return tipo;
	}

	public void setTipo(VehicleTypeEnum tipo) {
		this.tipo = tipo;
	}

	public List<TicketEntity> getTickets() {
		return this.tickets;
	}

	public void setTickets(List<TicketEntity> tickets) {
		this.tickets = tickets;
	}

	public TicketEntity addTicket(TicketEntity ticket) {
		getTickets().add(ticket);
		ticket.setVehicle(this);

		return ticket;
	}

	public TicketEntity removeTicket(TicketEntity ticket) {
		getTickets().remove(ticket);
		ticket.setVehicle(null);

		return ticket;
	}
}
