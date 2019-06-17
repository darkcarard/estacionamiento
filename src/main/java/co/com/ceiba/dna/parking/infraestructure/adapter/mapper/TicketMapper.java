package co.com.ceiba.dna.parking.infraestructure.adapter.mapper;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import co.com.ceiba.dna.parking.domain.entity.Ticket;
import co.com.ceiba.dna.parking.infraestructure.adapter.entity.TicketEntity;

@Component
public final class TicketMapper {
	
	private TicketMapper() {}
	
	public static TicketEntity toEntity(Ticket ticket) {
		TicketEntity ticketEntity = new TicketEntity();
		ticketEntity.setId(ticket.getId());
		ticketEntity.setEntryDate(localDateTimeToDate(ticket.getEntryDate()));
		if (ticket.getExitDate() != null) {
			ticketEntity.setExitDate(localDateTimeToDate(ticket.getExitDate()));
		}
		ticketEntity.setVehicle(VehicleMapper.toEntity(ticket.getVehicle()));
		if (ticket.getPaid() != null) {
			ticketEntity.setPaid(ticket.getPaid());
		}
		
		return ticketEntity;
	}
	
	public static Ticket toDomain(TicketEntity ticketEntity) {
		Ticket ticket = new Ticket();
		ticket.setId(ticketEntity.getId());
		ticket.setEntryDate(dateToLocalDateTime(ticketEntity.getEntryDate()));
		if (ticketEntity.getExitDate()!=null) {
			ticket.setExitDate(dateToLocalDateTime(ticketEntity.getExitDate()));
		}
		ticket.setVehicle(VehicleMapper.toDomain(ticketEntity.getVehicle()));
		if (ticketEntity.getPaid() != null) {
			ticket.setPaid(ticketEntity.getPaid());
		}
		
		return ticket;
	}
	
	public static List<Ticket> toDomain(List<TicketEntity> ticketEntities) {
		List<Ticket> tickets = new ArrayList<>();
		ticketEntities.forEach(ticketEntity->{
			Ticket ticket = toDomain(ticketEntity);
			tickets.add(ticket);
		});
		
		return tickets;
	}
	
	private static Date localDateTimeToDate(LocalDateTime inDate) {
		return Date.from(inDate.atZone(ZoneId.systemDefault()).toInstant());
	}
	
	private static LocalDateTime dateToLocalDateTime(Date inDate) {
		return LocalDateTime.ofInstant(inDate.toInstant(), ZoneId.systemDefault());
	}
}
