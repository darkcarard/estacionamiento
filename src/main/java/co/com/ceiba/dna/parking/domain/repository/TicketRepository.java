package co.com.ceiba.dna.parking.domain.repository;

import java.util.List;

import co.com.ceiba.dna.parking.domain.entity.Ticket;

public interface TicketRepository {
	
	public Ticket save(Ticket ticket);
	
	public List<Ticket> findAllTickets();
	
	public Ticket findTicketById(int ticketId);

}
