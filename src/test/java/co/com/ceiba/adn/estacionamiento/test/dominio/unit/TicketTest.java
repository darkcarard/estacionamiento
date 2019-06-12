package co.com.ceiba.adn.estacionamiento.test.dominio.unit;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.adn.estacionamiento.test.dominio.databuilder.TicketTestDataBuilder;
import co.com.ceiba.adn.estacionamiento.test.dominio.databuilder.VehiculoTestDataBuilder;
import co.com.ceiba.dna.parking.domain.entity.Ticket;
import co.com.ceiba.dna.parking.domain.entity.Vehicle;

public class TicketTest {

	private static final int DEFAULT_ID = 1;
	private static final LocalDateTime DEFAULT_FECHA_INGRESO = LocalDateTime.now();
	private static final Vehicle DEFAULT_VEHICULO = new VehiculoTestDataBuilder().build();

	private Ticket ticket;
	
	@Before
	public void setUp() {

		TicketTestDataBuilder ticketTestDataBuilder = new TicketTestDataBuilder().withId(DEFAULT_ID)
				.withFechaIngreso(DEFAULT_FECHA_INGRESO).withVehiculo(DEFAULT_VEHICULO);
		ticket = ticketTestDataBuilder.build();
	}
	
	@Test
	public void ticketBuild() {
		assertEquals(DEFAULT_ID, ticket.getId());
		assertEquals(DEFAULT_FECHA_INGRESO, ticket.getFechaIngreso());
		assertEquals(DEFAULT_VEHICULO, ticket.getVehiculo());
	}
}
