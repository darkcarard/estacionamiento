package co.com.ceiba.dna.parking.test.infraestructure.unit;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.dna.parking.domain.entity.Ticket;
import co.com.ceiba.dna.parking.infraestructure.adapter.entity.TicketEntity;
import co.com.ceiba.dna.parking.infraestructure.adapter.mapper.TicketMapper;
import co.com.ceiba.dna.parking.test.domain.databuilder.TicketTestDataBuilder;
import co.com.ceiba.dna.parking.test.infraestructure.databuilder.TicketEntityTestDataBuilder;

public class TicketMapperTest {

	private Ticket ticket;
	private TicketEntity ticketEntity;
	
	private TicketTestDataBuilder ticketTestDataBuilder;
	private TicketEntityTestDataBuilder ticketEntitytTestDataBuilder;
	
	private static final String DATES_FORMAT = "yyyy-MM-dd HH:mm:ss";
	private static final DateTimeFormatter LOCAL_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATES_FORMAT);
	private SimpleDateFormat dateFormatter = new SimpleDateFormat(DATES_FORMAT);
	
	@Before
	public void setUp() {
		ticketTestDataBuilder = new TicketTestDataBuilder().withExitDate(LocalDateTime.now());
		ticketEntitytTestDataBuilder = new TicketEntityTestDataBuilder().withExitDate(new Date());
	}
	
	@Test
	public void domainTicketToEntityTicket() {
		ticket = ticketTestDataBuilder.build();
		ticketEntity = TicketMapper.toEntity(ticket);
		assertEquals(ticket.getId(), ticketEntity.getId());
		assertEquals(ticket.getEntryDate().format(LOCAL_DATE_TIME_FORMATTER), dateFormatter.format(ticketEntity.getEntryDate()));
		assertEquals(ticket.getExitDate().format(LOCAL_DATE_TIME_FORMATTER), dateFormatter.format(ticketEntity.getExitDate()));
		assertEquals(ticket.getVehicle().getLicensePlate(), ticketEntity.getVehicle().getLicensePlate());
		assertEquals(ticket.getVehicle().getCylinderCapacity(), ticketEntity.getVehicle().getCylinderCapacity());
		assertEquals(ticket.getVehicle().getVehicleType(), ticketEntity.getVehicle().getVehicleType());
	}
	
	@Test
	public void entityTicketToDomainTicket() {
		ticketEntity = ticketEntitytTestDataBuilder.build();
		ticket = TicketMapper.toDomain(ticketEntity);
		assertEquals(ticketEntity.getId(), ticket.getId());
		assertEquals(dateFormatter.format(ticketEntity.getEntryDate()), ticket.getEntryDate().format(LOCAL_DATE_TIME_FORMATTER));
		assertEquals(dateFormatter.format(ticketEntity.getExitDate()), ticket.getExitDate().format(LOCAL_DATE_TIME_FORMATTER));
		assertEquals(ticketEntity.getVehicle().getLicensePlate(), ticket.getVehicle().getLicensePlate());
		assertEquals(ticketEntity.getVehicle().getCylinderCapacity(), ticket.getVehicle().getCylinderCapacity());
		assertEquals(ticketEntity.getVehicle().getVehicleType(), ticket.getVehicle().getVehicleType());
	}
	
	@Test
	public void domainTicketToEntityTicketWithNullExitDate() {
		ticketTestDataBuilder.withExitDate(null);
		ticket = ticketTestDataBuilder.build();
		ticketEntity = TicketMapper.toEntity(ticket);
		assertEquals(ticket.getId(), ticketEntity.getId());
		assertEquals(ticket.getEntryDate().format(LOCAL_DATE_TIME_FORMATTER), dateFormatter.format(ticketEntity.getEntryDate()));
		assertNull(ticketEntity.getExitDate());
		assertEquals(ticket.getVehicle().getLicensePlate(), ticketEntity.getVehicle().getLicensePlate());
		assertEquals(ticket.getVehicle().getCylinderCapacity(), ticketEntity.getVehicle().getCylinderCapacity());
		assertEquals(ticket.getVehicle().getVehicleType(), ticketEntity.getVehicle().getVehicleType());
	}
	
	@Test
	public void entityTicketToDomainTicketWithNullExitDate() {
		ticketEntitytTestDataBuilder.withExitDate(null);
		ticketEntity = ticketEntitytTestDataBuilder.build();
		ticket = TicketMapper.toDomain(ticketEntity);
		assertEquals(ticketEntity.getId(), ticket.getId());
		assertEquals(dateFormatter.format(ticketEntity.getEntryDate()), ticket.getEntryDate().format(LOCAL_DATE_TIME_FORMATTER));
		assertNull(ticket.getExitDate());
		assertEquals(ticketEntity.getVehicle().getLicensePlate(), ticket.getVehicle().getLicensePlate());
		assertEquals(ticketEntity.getVehicle().getCylinderCapacity(), ticket.getVehicle().getCylinderCapacity());
		assertEquals(ticketEntity.getVehicle().getVehicleType(), ticket.getVehicle().getVehicleType());
	}
}
