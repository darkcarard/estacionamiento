package co.com.ceiba.adn.estacionamiento.test.dominio.unit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.adn.estacionamiento.dominio.entity.TipoVehiculo;
import co.com.ceiba.adn.estacionamiento.dominio.entity.Vehiculo;
import co.com.ceiba.adn.estacionamiento.test.dominio.databuilder.VehiculoTestDataBuilder;

public class VehiculoTest {

	private static final String PLACA = "ABC123";
	private static final int CILINDRAJE = 1500;
	private static final TipoVehiculo TIPO = new TipoVehiculo(1);
	
	private Vehiculo vehiculo; 
	
	@Before
	public void setUp() {
		
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().withPlaca(PLACA).withCilindraje(CILINDRAJE).withTipo(TIPO);
		vehiculo = vehiculoTestDataBuilder.build();
	}
	
	@Test
	public void vehiculoBuild() {

		assertEquals(PLACA, vehiculo.getPlaca());
	}

}
