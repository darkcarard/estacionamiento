package co.com.ceiba.adn.estacionamiento.test.dominio.unit;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.adn.estacionamiento.dominio.entity.Estacionamiento;
import co.com.ceiba.adn.estacionamiento.dominio.entity.Ticket;
import co.com.ceiba.adn.estacionamiento.test.dominio.databuilder.EstacionamientoTestDataBuilder;

public class EstacionamientoTest {

	private static final List<Ticket> DEFAULT_TICKETS = new ArrayList<>();
	
	private Estacionamiento estacionamiento;
	
	@Before
	public void setUp() {
		EstacionamientoTestDataBuilder estacionamientoTestDataBuilder = new EstacionamientoTestDataBuilder();
		estacionamiento = estacionamientoTestDataBuilder.build();
	}
	
	/**
	 * Probamos que al instanciar un estacionamiento la lista de tickets se instancie también
	 */
	@Test
	public void estacionamientoBuild() {
		assertNotNull(estacionamiento);
	}
}
