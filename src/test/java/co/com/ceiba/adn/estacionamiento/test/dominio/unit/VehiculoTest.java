package co.com.ceiba.adn.estacionamiento.test.dominio.unit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.adn.estacionamiento.dominio.entity.TipoVehiculoEnum;
import co.com.ceiba.adn.estacionamiento.dominio.entity.Vehiculo;
import co.com.ceiba.adn.estacionamiento.dominio.exception.EstacionamientoException;
import co.com.ceiba.adn.estacionamiento.test.dominio.BasePrueba;
import co.com.ceiba.adn.estacionamiento.test.dominio.databuilder.VehiculoTestDataBuilder;

public class VehiculoTest {

	private static final String PLACA = "ABC123";
	private static final int CILINDRAJE = 1500;
	private static final TipoVehiculoEnum TIPO = TipoVehiculoEnum.CARRO;
	private static final String MENSAJE_PLACA_OBLIGATORIA = "El número de placa es obligatorio";
	private static final String MENSAJE_CILINDRAJE_MAYO_CERO = "El cilindraje no puede ser cero o negativo";
	private static final String MENSAJE_TIPO_OBLIGATORIO = "El tipo del vehículo es obligatorio";
	
	
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
	
	@Test
	public void vehiculoPlacaObligatoria() {
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().withPlaca(null);
		BasePrueba.assertThrows(vehiculoTestDataBuilder::build, EstacionamientoException.class, MENSAJE_PLACA_OBLIGATORIA);
	}
	
	@Test
	public void vehiculoCilindrajeObligatorio() {
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().withCilindraje(0);
		BasePrueba.assertThrows(vehiculoTestDataBuilder::build, EstacionamientoException.class, MENSAJE_CILINDRAJE_MAYO_CERO);
	}

	@Test
	public void vehiculoTipoObligatorio() {
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().withTipo(null);
		BasePrueba.assertThrows(vehiculoTestDataBuilder::build, EstacionamientoException.class, MENSAJE_TIPO_OBLIGATORIO);
	}

	
}
