package co.com.ceiba.adn.estacionamiento.test.dominio.databuilder;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.dna.parking.domain.entity.Parking;
import co.com.ceiba.dna.parking.domain.entity.Ticket;

public class EstacionamientoTestDataBuilder {
	
	private static final List<Ticket> DEFAULT_TICKETS = new ArrayList<>();
	
	private List<Ticket> tickets;
	
	public EstacionamientoTestDataBuilder() {
		tickets = DEFAULT_TICKETS;
	}

	public EstacionamientoTestDataBuilder withTickets(List<Ticket> tickets) {
		this.tickets = tickets;
		return this;
	}
	
	public Parking build() {
		return new Parking(tickets);
	}
	
}
