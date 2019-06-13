package co.com.ceiba.dna.parking.domain.entity;

import java.time.LocalDateTime;

public class Ticket {

	private int id;
	private LocalDateTime entryDate;
	private LocalDateTime exitDate;
	private Vehicle vehicle;
	private Byte paid;
	
	public Ticket() {
		
	}

	public Ticket(int id, LocalDateTime entryDate, LocalDateTime exitDate, Vehicle vehicle, byte paid) {
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

	public LocalDateTime getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(LocalDateTime entryDate) {
		this.entryDate = entryDate;
	}

	public LocalDateTime getExitDate() {
		return exitDate;
	}

	public void setExitDate(LocalDateTime exitDate) {
		this.exitDate = exitDate;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Byte getPaid() {
		return paid;
	}

	public void setPaid(Byte paid) {
		this.paid = paid;
	}

}
