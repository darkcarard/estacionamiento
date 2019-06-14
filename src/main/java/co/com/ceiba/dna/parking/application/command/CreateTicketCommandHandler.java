package co.com.ceiba.dna.parking.application.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ceiba.dna.parking.domain.entity.Ticket;
import co.com.ceiba.dna.parking.domain.repository.TicketRepository;

@Component
public class CreateTicketCommandHandler {

	private TicketRepository ticketRepository;
	
	@Autowired
	public CreateTicketCommandHandler(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}

	public Ticket handler(Ticket ticket) {
		return ticketRepository.save(ticket);
	}
	
}
