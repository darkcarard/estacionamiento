package co.com.ceiba.adn.estacionamiento.test.dominio.unit;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.adn.estacionamiento.dominio.entity.Estacionamiento;
import co.com.ceiba.adn.estacionamiento.dominio.entity.Ticket;
import co.com.ceiba.adn.estacionamiento.dominio.entity.Vehiculo;
import co.com.ceiba.adn.estacionamiento.dominio.exception.EstacionamientoException;
import co.com.ceiba.adn.estacionamiento.test.dominio.BasePrueba;
import co.com.ceiba.adn.estacionamiento.test.dominio.databuilder.EstacionamientoTestDataBuilder;
import co.com.ceiba.adn.estacionamiento.test.dominio.databuilder.TicketTestDataBuilder;
import co.com.ceiba.adn.estacionamiento.test.dominio.databuilder.VehiculoTestDataBuilder;

public class EstacionamientoTest {

	private static final LocalDateTime FECHA_INGRESO = LocalDateTime.now();
	//Esta fecha es un domingo
	private static final LocalDateTime FECHA_INGRESO_AUTORIZADO = LocalDateTime.of(2019, Month.JUNE, 9, 10, 0);
	//Esta fecha es un martes
	private static final LocalDateTime FECHA_INGRESO_NO_AUTORIZADO = LocalDateTime.of(2019, Month.JUNE, 11, 10, 0);
	private static final String PLACA_EMPIEZA_POR_A = "ABC123";
	private static final String PLACA_NO_EMPIEZA_POR_A = "BCD123";
	private static final String MENSAJE_CUPO_LLENO = "Ya no hay cupo para el tipo de vehículo";
	private static final String MENSAJE_INGRESO_PLACA_NO_AUTORIZADA = "El vehículo no está autorizado para ingresar al estacionamiento el día de hoy";

	private Estacionamiento estacionamiento;
	private Vehiculo vehiculo;

	@Before
	public void setUp() {
		EstacionamientoTestDataBuilder estacionamientoTestDataBuilder = new EstacionamientoTestDataBuilder();
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		estacionamiento = estacionamientoTestDataBuilder.build();
		vehiculo = vehiculoTestDataBuilder.build();
	}

	/**
	 * Probamos que al instanciar un estacionamiento la lista de tickets se
	 * instancie también
	 */
	@Test
	public void estacionamientoBuild() {
		assertNotNull(estacionamiento);
	}

	/**
	 * Probamos que se cree un ticket correctamente al ingresar un vehículo y haya
	 * cupo para el tipo de vehículo. Se garantiza que hay cupo puesto que la lista
	 * de tickets está vacía.
	 */
	@Test
	public void ingresarVehiculoConCuposDisponibles() {
		Ticket ticket;
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().withPlaca(PLACA_NO_EMPIEZA_POR_A);
		vehiculo = vehiculoTestDataBuilder.build();
		ticket = estacionamiento.ingresarVehiculo(vehiculo, FECHA_INGRESO_AUTORIZADO);
		assertNotNull(ticket);
	}

	/**
	 * Probamos que se muestre un mensaje de error si no hay cupo para el tipo de
	 * vehículo
	 */
	@Test
	public void ingresarVehiculoSinCuposDisponibles() {
		TicketTestDataBuilder ticketTestDataBuilder = new TicketTestDataBuilder();
		List<Ticket> tickets = new ArrayList<>();
		Ticket ticket;
		for (int i = 0; i < vehiculo.getTipo().getCantidadMaxima(); i++) {
			ticket = ticketTestDataBuilder.withId(i).withVehiculo(vehiculo).build();
			tickets.add(ticket);
		}
		estacionamiento.setTickets(tickets);
		BasePrueba.assertThrows(() -> estacionamiento.ingresarVehiculo(vehiculo, FECHA_INGRESO),
				EstacionamientoException.class, MENSAJE_CUPO_LLENO);

	}
	
	@Test
	public void ingresarVehiculoConPlacaAEnDiaAutorizado() {
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().withPlaca(PLACA_EMPIEZA_POR_A);
		vehiculo = vehiculoTestDataBuilder.build();
		Ticket ticket = estacionamiento.ingresarVehiculo(vehiculo, FECHA_INGRESO_AUTORIZADO);
		assertNotNull(ticket);
	}
	
	@Test
	public void ingresarVehiculoConPlacaAEnDiaNoAutorizado() {
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().withPlaca(PLACA_EMPIEZA_POR_A);
		vehiculo = vehiculoTestDataBuilder.build();
		BasePrueba.assertThrows(() -> estacionamiento.ingresarVehiculo(vehiculo, FECHA_INGRESO_NO_AUTORIZADO),
				EstacionamientoException.class, MENSAJE_INGRESO_PLACA_NO_AUTORIZADA);
	}
	
	@Test
	public void ingresarVehiculoConPlacaNoAEnDiaAutorizado() {
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().withPlaca(PLACA_NO_EMPIEZA_POR_A);
		vehiculo = vehiculoTestDataBuilder.build();
		Ticket ticket = estacionamiento.ingresarVehiculo(vehiculo, FECHA_INGRESO_AUTORIZADO);
		assertNotNull(ticket);
	}
	
	@Test
	public void ingresarVehiculoConPlacaNoAEnDiaNoAutorizado() {
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().withPlaca(PLACA_NO_EMPIEZA_POR_A);
		vehiculo = vehiculoTestDataBuilder.build();
		Ticket ticket = estacionamiento.ingresarVehiculo(vehiculo, FECHA_INGRESO_NO_AUTORIZADO);
		assertNotNull(ticket);
	}
}
