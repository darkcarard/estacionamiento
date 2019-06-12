package co.com.ceiba.dna.parking.test.domain.unit;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.dna.parking.domain.entity.Ticket;
import co.com.ceiba.dna.parking.domain.entity.Vehicle;
import co.com.ceiba.dna.parking.test.domain.databuilder.TicketTestDataBuilder;
import co.com.ceiba.dna.parking.test.domain.databuilder.VehicleTestDataBuilder;

public class TicketTest {

	private static final int DEFAULT_ID = 1;
	private static final LocalDateTime DEFAULT_ENTRY_DATE = LocalDateTime.now();
	private static final Vehicle DEFAULT_VEHICLE = new VehicleTestDataBuilder().build();

	private Ticket ticket;
	
	@Before
	public void setUp() {

		TicketTestDataBuilder ticketTestDataBuilder = new TicketTestDataBuilder().withId(DEFAULT_ID)
				.withEntryDate(DEFAULT_ENTRY_DATE).withVehicle(DEFAULT_VEHICLE);
		ticket = ticketTestDataBuilder.build();
	}
	
	@Test
	public void ticketBuild() {
		assertEquals(DEFAULT_ID, ticket.getId());
		assertEquals(DEFAULT_ENTRY_DATE, ticket.getEntryDate());
		assertEquals(DEFAULT_VEHICLE, ticket.getVehicle());
	}
}
