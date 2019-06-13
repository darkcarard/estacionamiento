package co.com.ceiba.dna.parking.test.domain.databuilder;

import java.time.LocalDateTime;

import co.com.ceiba.dna.parking.domain.entity.Ticket;
import co.com.ceiba.dna.parking.domain.entity.Vehicle;

public class TicketTestDataBuilder {
	
	private static final int DEFAULT_ID = 1;
	private static final LocalDateTime DEFAULT_ENTRY_DATE = LocalDateTime.now();
	private static final Vehicle DEFAULT_VEHICLE = new VehicleTestDataBuilder().build();
	private static final byte DEFAULT_PAID = 0;
	
	private int id;
	private LocalDateTime entryDate;
	private LocalDateTime exitDate;
	private Vehicle vehicle;
	private byte paid;
	
	public TicketTestDataBuilder() {
		
		this.id = DEFAULT_ID;
		this.entryDate = DEFAULT_ENTRY_DATE;
		this.vehicle = DEFAULT_VEHICLE;
		this.paid = DEFAULT_PAID;
	}
	
	public TicketTestDataBuilder withId (int id) {
		this.id = id;
		return this;
	}
	
	public TicketTestDataBuilder withEntryDate(LocalDateTime entryDate) {
		this.entryDate = entryDate;
		return this;
	}
	
	public TicketTestDataBuilder withExitDate(LocalDateTime exitDate) {
		this.exitDate = exitDate;
		return this;
	}
	
	public TicketTestDataBuilder withVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
		return this;
	}
	
	public TicketTestDataBuilder withPaid(byte paid) {
		this.paid = paid;
		return this;
	}
	
	public Ticket build() {
		return new Ticket(id, entryDate, exitDate, vehicle, paid);
	}

}
