package co.com.ceiba.dna.parking.infraestructure.adapter.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ticket")
public class TicketEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "entry_date")
	private Date entryDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "exit_date")
	private Date exitDate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "vehicle")
	private VehicleEntity vehicle;

	private Byte paid = 0;

	public TicketEntity() {

	}

	public TicketEntity(int id, Date entryDate, Date exitDate, VehicleEntity vehicle, Byte paid) {
		this.id = id;
		this.entryDate = entryDate;
		this.exitDate = exitDate;
		this.vehicle = vehicle;
		this.paid = paid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Date getExitDate() {
		return exitDate;
	}

	public void setExitDate(Date exitDate) {
		this.exitDate = exitDate;
	}

	public Byte getPaid() {
		return this.paid;
	}

	public void setPaid(Byte paid) {
		this.paid = paid;
	}

	public VehicleEntity getVehicle() {
		return this.vehicle;
	}

	public void setVehicle(VehicleEntity vehicle) {
		this.vehicle = vehicle;
	}
}
