package co.com.ceiba.dna.parking.test.domain.databuilder;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.dna.parking.domain.entity.Parking;
import co.com.ceiba.dna.parking.domain.entity.Ticket;

public class ParkingTestDataBuilder {
	
	private static final List<Ticket> DEFAULT_TICKETS = new ArrayList<>();
	
	private List<Ticket> tickets;
	
	public ParkingTestDataBuilder() {
		tickets = DEFAULT_TICKETS;
	}

	public ParkingTestDataBuilder withTickets(List<Ticket> tickets) {
		this.tickets = tickets;
		return this;
	}
	
	public Parking build() {
		return new Parking(tickets);
	}
	
}
