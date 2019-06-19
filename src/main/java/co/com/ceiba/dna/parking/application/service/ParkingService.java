package co.com.ceiba.dna.parking.application.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.dna.parking.domain.entity.Parking;
import co.com.ceiba.dna.parking.domain.entity.Ticket;
import co.com.ceiba.dna.parking.domain.entity.Vehicle;
import co.com.ceiba.dna.parking.domain.repository.TicketRepository;

@Service
public class ParkingService {
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private Parking parking;
	
	public Ticket vehicleCheckIn(Vehicle vehicle, LocalDateTime entryDate) {	
		return ticketRepository.save(parking.vehicleCheckIn(vehicle, entryDate));
	}
	
	public float calculatePrice(int ticketId) {
		Ticket ticket = ticketRepository.findTicketById(ticketId);
		ticket.setExitDate(LocalDateTime.now());
		return parking.calculatePrice(ticket);
	}
	
	public void checkOutVehicle(int ticketId) {
		Ticket ticket = ticketRepository.findTicketById(ticketId);
		ticket.setPaid(true);
		ticketRepository.save(ticket);
	}
}
