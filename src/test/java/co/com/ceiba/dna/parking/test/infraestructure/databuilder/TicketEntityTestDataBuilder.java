package co.com.ceiba.dna.parking.test.infraestructure.databuilder;

import java.util.Date;

import co.com.ceiba.dna.parking.infraestructure.adapter.entity.TicketEntity;
import co.com.ceiba.dna.parking.infraestructure.adapter.entity.VehicleEntity;

public class TicketEntityTestDataBuilder {
	
	private static final int DEFAULT_ID = 1;
	private static final Date DEFAULT_ENTRY_DATE = new Date();
	private static final VehicleEntity DEFAULT_VEHICLE = new VehicleEntityTestDataBuilder().build();
	private static final Byte DEFAULT_PAID = 0;
	
	private int id;
	private Date entryDate;
	private Date exitDate;
	private VehicleEntity vehicle;
	private Byte paid;
	
	public TicketEntityTestDataBuilder() {
		
		this.id = DEFAULT_ID;
		this.entryDate = DEFAULT_ENTRY_DATE;
		this.vehicle = DEFAULT_VEHICLE;
		this.paid = DEFAULT_PAID;
	}
	
	public TicketEntityTestDataBuilder withId (int id) {
		this.id = id;
		return this;
	}
	
	public TicketEntityTestDataBuilder withEntryDate(Date entryDate) {
		this.entryDate = entryDate;
		return this;
	}
	
	public TicketEntityTestDataBuilder withExitDate(Date exitDate) {
		this.exitDate = exitDate;
		return this;
	}
	
	public TicketEntityTestDataBuilder withVehicle(VehicleEntity vehicle) {
		this.vehicle = vehicle;
		return this;
	}
	
	public TicketEntityTestDataBuilder withPaid(Byte paid) {
		this.paid = paid;
		return this;
	}
	
	public TicketEntity build() {
		return new TicketEntity(id, entryDate, exitDate, vehicle, paid);
	}

}
