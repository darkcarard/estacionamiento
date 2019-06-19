package co.com.ceiba.dna.parking.infraestructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.dna.parking.application.service.TicketService;
import co.com.ceiba.dna.parking.domain.entity.Ticket;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/tickets")
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@PostMapping
	public ResponseEntity<Ticket> saveTicket(@RequestBody Ticket ticket) {
		Ticket ticketTmp = ticketService.saveTicket(ticket);
		return new ResponseEntity<>(ticketTmp, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Ticket>> findAllTickets() {
		List<Ticket> tickets = ticketService.findAllTickets();
		return new ResponseEntity<>(tickets, HttpStatus.OK);
	}
}
