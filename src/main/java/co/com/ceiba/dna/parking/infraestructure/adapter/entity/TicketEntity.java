package co.com.ceiba.dna.parking.infraestructure.adapter.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ticket")
public class TicketEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_ingreso")
	private Date entryDate;

	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_salida")
	private Date exitDate;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "vehiculo")
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
