package co.com.ceiba.dna.parking.domain.entity;

import java.time.LocalDateTime;

public class Ticket {

	private int id;
	private LocalDateTime entryDate;
	private LocalDateTime exitDate;
	private Vehicle vehicle;
	
	public Ticket() {
		
	}

	public Ticket(int id, LocalDateTime entryDate, LocalDateTime exitDate, Vehicle vehicle) {
		this.id = id;
		this.entryDate = entryDate;
		this.exitDate = exitDate;
		this.vehicle = vehicle;
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
	
}
