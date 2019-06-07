package co.com.ceiba.adn.estacionamiento.test.dominio.databuilder;

import co.com.ceiba.adn.estacionamiento.dominio.entity.TipoVehiculo;
import co.com.ceiba.adn.estacionamiento.dominio.entity.Vehiculo;

public class VehiculoTestDataBuilder {
	
	private static final String PLACA = "ABC123";
	private static final int CILINDRAJE = 1500;
	private static final TipoVehiculo TIPO = new TipoVehiculo(1);
	
	private String placa;
	private int cilindraje;
	private TipoVehiculo tipo;
	
	public VehiculoTestDataBuilder() {
		
		placa = PLACA;
		cilindraje = CILINDRAJE;
		tipo = TIPO;
	}
	
	public VehiculoTestDataBuilder withPlaca(String placa) {
		this.placa = placa;
		
		return this;
	}
	
	public VehiculoTestDataBuilder withCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
		
		return this;
	}
	
	public VehiculoTestDataBuilder withTipo(TipoVehiculo tipo) {
		this.tipo = tipo;
		
		return this;
	}
	
	public Vehiculo build() {
		
		Vehiculo vehiculo = new Vehiculo(placa, cilindraje, tipo);
		
		return vehiculo;
	}

}
