package co.com.ceiba.dna.parking.infraestructure.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.dna.parking.application.service.ParkingService;
import co.com.ceiba.dna.parking.domain.entity.Ticket;
import co.com.ceiba.dna.parking.domain.entity.Vehicle;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/parking")
public class ParkingController {

	@Autowired
	private ParkingService parkingService;
	
	@PostMapping("/checkIn/{entryDate}")
	@ResponseStatus(HttpStatus.CREATED)
	public Ticket checkInVehicle(@RequestBody Vehicle vehicle, @PathVariable String entryDate) { 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime entryDateFormatted = LocalDateTime.parse(entryDate, formatter);
		return parkingService.vehicleCheckIn(vehicle, entryDateFormatted);
	}
	
	@GetMapping("/price/{ticketId}")
	public float calculatePrice(@PathVariable int ticketId) {
		return parkingService.calculatePrice(ticketId);
	}
	
	@GetMapping("/pay/{ticketId}")
	public void checkOutVehicle(@PathVariable int ticketId) {
		parkingService.checkOutVehicle(ticketId);
	}
}
