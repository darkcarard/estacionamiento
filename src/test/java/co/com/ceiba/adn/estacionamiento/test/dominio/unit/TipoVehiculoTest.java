package co.com.ceiba.adn.estacionamiento.test.dominio.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.adn.estacionamiento.dominio.entity.TipoVehiculo;
import co.com.ceiba.adn.estacionamiento.test.dominio.databuilder.TipoVehiculoTestDataBuilder;

public class TipoVehiculoTest {

	private static final int ID = 1;
	private static final String NOMBRE = "Carro";
	private static final String DESCRIPCION = "Vehículos de 4 ruedas";
	private static final float VALOR_HORA = 1000F;
	private static final float VALOR_DIA = 8000F;
	private static final int CANTIDAD_MAXIMA = 20;

	private TipoVehiculo tipoVehiculo;

	@Before
	public void setUp() {

		TipoVehiculoTestDataBuilder tipoVehiculoTestDataBuilder = new TipoVehiculoTestDataBuilder().withId(ID)
				.withNombre(NOMBRE).withDescripcion(DESCRIPCION).withValorHora(VALOR_HORA).withValorDia(VALOR_DIA)
				.withCantidadMaxima(CANTIDAD_MAXIMA);
		tipoVehiculo = tipoVehiculoTestDataBuilder.build();
	}

	@Test
	public void tipoVehiculoBuild() {
		assertEquals(ID, tipoVehiculo.getId());
		assertEquals(NOMBRE, tipoVehiculo.getNombre());
		assertEquals(DESCRIPCION, tipoVehiculo.getDescripcion());
		assertEquals(VALOR_HORA, tipoVehiculo.getValorHora(), 0);
		assertEquals(VALOR_DIA, tipoVehiculo.getValorDia(), 0);
		assertEquals(CANTIDAD_MAXIMA, tipoVehiculo.getCantidadMaxima());
	}

}
