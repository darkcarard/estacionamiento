package co.com.ceiba.dna.parking.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.com.ceiba.dna.parking.domain.entity.Ticket;
import co.com.ceiba.dna.parking.domain.repository.TicketRepository;

@Service
public class TicketService {

	private TicketRepository ticketRepository;

	public TicketService(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}
	
	public Ticket saveTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}
	
	public List<Ticket> findAllTickets() {
		return ticketRepository.findAllTickets();
	}
}
