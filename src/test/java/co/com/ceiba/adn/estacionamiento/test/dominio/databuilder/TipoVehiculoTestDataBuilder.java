package co.com.ceiba.adn.estacionamiento.test.dominio.databuilder;

import co.com.ceiba.adn.estacionamiento.dominio.entity.TipoVehiculo;
import co.com.ceiba.adn.estacionamiento.dominio.entity.Vehiculo;

public class TipoVehiculoTestDataBuilder {
	
	private static final int ID = 1;
	private static final String NOMBRE = "Carro";
	private static final String DESCRIPCION = "Vehículos de 4 ruedas";
	private static final float VALOR_HORA = 1000F;
	private static final float VALOR_DIA = 8000F;
	private static final int CANTIDAD_MAXIMA = 20;
	
	private int id;
	private String nombre;
	private String descripcion;
	private float valorHora;
	private float valorDia;
	private int cantidadMaxima;
	
	public TipoVehiculoTestDataBuilder() {
		id = ID;
		nombre = NOMBRE;
		descripcion = DESCRIPCION;
		valorHora = VALOR_HORA;
		valorDia = VALOR_DIA;
		cantidadMaxima = CANTIDAD_MAXIMA;
	}
	
	public TipoVehiculoTestDataBuilder withId(int id) {
		this.id = id;
		
		return this;
	}
	
	public TipoVehiculoTestDataBuilder withNombre(String nombre) {
		this.nombre = nombre;
		
		return this;
	}
	
	public TipoVehiculoTestDataBuilder withDescripcion(String descripcion) {
		this.descripcion = descripcion;
		
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
		
		return new TipoVehiculo(id, nombre, descripcion, valorHora, valorDia, cantidadMaxima);
		
	}

}
