package co.com.ceiba.adn.estacionamiento.test.dominio.databuilder;

import co.com.ceiba.adn.estacionamiento.dominio.entity.TipoVehiculoEnum;
import co.com.ceiba.adn.estacionamiento.dominio.entity.Vehiculo;

public class VehiculoTestDataBuilder {
	
	private static final String DEFAULT_PLACA = "ABC123";
	private static final int DEFAULT_CILINDRAJE = 1500;
	private static final TipoVehiculoEnum DEFAULT_TIPO = TipoVehiculoEnum.CARRO;
	
	private String placa;
	private int cilindraje;
	private TipoVehiculoEnum tipo;
	
	public VehiculoTestDataBuilder() {
		
		placa = DEFAULT_PLACA;
		cilindraje = DEFAULT_CILINDRAJE;
		tipo = DEFAULT_TIPO;
	}
	
	public VehiculoTestDataBuilder withPlaca(String placa) {
		this.placa = placa;
		
		return this;
	}
	
	public VehiculoTestDataBuilder withCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
		
		return this;
	}
	
	public VehiculoTestDataBuilder withTipo(TipoVehiculoEnum tipo) {
		this.tipo = tipo;
		
		return this;
	}
	
	public Vehiculo build() {
		
		return new Vehiculo(placa, cilindraje, tipo);
		
	}

}
