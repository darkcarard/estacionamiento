package co.com.ceiba.dna.parking.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Ticket> saveTicket(@RequestBody Ticket ticket) {
		Ticket ticketTmp = createTicketCommandHandler.handler(ticket);
		return new ResponseEntity<>(ticketTmp, HttpStatus.CREATED);
	}
}
