package co.com.ceiba.adn.estacionamiento.test.dominio.databuilder;

import co.com.ceiba.adn.estacionamiento.dominio.entity.TipoVehiculo;

public class TipoVehiculoTestDataBuilder {
	
	private static final byte ID = 1;
	private static final String NOMBRE = "Carro";
	private static final float VALOR_HORA = 1000F;
	private static final float VALOR_DIA = 8000F;
	private static final int CANTIDAD_MAXIMA = 20;
	
	private byte id;
	private String nombre;
	private float valorHora;
	private float valorDia;
	private int cantidadMaxima;
	
	public TipoVehiculoTestDataBuilder() {
		id = ID;
		nombre = NOMBRE;
		valorHora = VALOR_HORA;
		valorDia = VALOR_DIA;
		cantidadMaxima = CANTIDAD_MAXIMA;
	}
	
	public TipoVehiculoTestDataBuilder withId(byte id) {
		this.id = id;
		
		return this;
	}
	
	public TipoVehiculoTestDataBuilder withNombre(String nombre) {
		this.nombre = nombre;
		
		return this;
	}
	
	public TipoVehiculoTestDataBuilder withValorHora(float valorHora) {
		this.valorHora = valorHora;
		
		return this;
	}
	
	public TipoVehiculoTestDataBuilder withValorDia(float valorDia) {
		this.valorDia = valorDia;
		
		return this;
	}
	
	public TipoVehiculoTestDataBuilder withCantidadMaxima(int cantidadMaxima) {
		this.cantidadMaxima = cantidadMaxima;
		
		return this;
	}
	
	public TipoVehiculo build() {
		
		return new TipoVehiculo(id, nombre, valorHora, valorDia, cantidadMaxima);
		
	}

}
