package co.com.ceiba.dna.parking.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.dna.parking.application.command.CreateTicketCommandHandler;
import co.com.ceiba.dna.parking.domain.entity.Ticket;

@RestController
@RequestMapping("/tickets")
public class TicketController {

	private CreateTicketCommandHandler createTicketCommandHandler;
	
	@Autowired
	public TicketController(CreateTicketCommandHandler createTicketCommandHandler) {
		this.createTicketCommandHandler = createTicketCommandHandler;
	}

	@PostMapping
	public void saveTicket(@RequestBody Ticket ticket) {
		createTicketCommandHandler.handler(ticket);
	}
}
