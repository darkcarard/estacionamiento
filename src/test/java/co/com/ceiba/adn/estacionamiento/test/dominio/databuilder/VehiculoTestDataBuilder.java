package co.com.ceiba.adn.estacionamiento.test.dominio.databuilder;

import co.com.ceiba.dna.parking.domain.entity.VehicleTypeEnum;
import co.com.ceiba.dna.parking.domain.entity.Vehicle;

public class VehiculoTestDataBuilder {
	
	private static final String DEFAULT_PLACA = "ABC123";
	private static final int DEFAULT_CILINDRAJE = 1500;
	private static final VehicleTypeEnum DEFAULT_TIPO = VehicleTypeEnum.CARRO;
	
	private String placa;
	private int cilindraje;
	private VehicleTypeEnum tipo;
	
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
	
	public VehiculoTestDataBuilder withTipo(VehicleTypeEnum tipo) {
		this.tipo = tipo;
		
		return this;
	}
	
	public Vehicle build() {
		
		return new Vehicle(placa, cilindraje, tipo);
		
	}

}
