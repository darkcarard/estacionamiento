package co.com.ceiba.adn.estacionamiento.test.dominio.databuilder;

import java.time.LocalDateTime;

import co.com.ceiba.adn.estacionamiento.dominio.entity.Ticket;
import co.com.ceiba.adn.estacionamiento.dominio.entity.Vehiculo;

public class TicketTestDataBuilder {
	
	private static final int DEFAULT_ID = 1;
	private static final LocalDateTime DEFAULT_FECHA_INGRESO = LocalDateTime.now();
	private static final Vehiculo DEFAULT_VEHICULO = new VehiculoTestDataBuilder().build();
	
	private int id;
	private LocalDateTime fechaIngreso;
	private LocalDateTime fechaSalida;
	private Vehiculo vehiculo;
	
	public TicketTestDataBuilder() {
		
		this.id = DEFAULT_ID;
		this.fechaIngreso = DEFAULT_FECHA_INGRESO;
		this.vehiculo = DEFAULT_VEHICULO;
	}
	
	public TicketTestDataBuilder withId (int id) {
		this.id = id;
		return this;
	}
	
	public TicketTestDataBuilder withFechaIngreso(LocalDateTime fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
		return this;
	}
	
	public TicketTestDataBuilder withFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
		return this;
	}
	
	public TicketTestDataBuilder withVehiculo(Vehiculo vehiculo ) {
		this.vehiculo = vehiculo;
		return this;
	}
	
	public Ticket build() {
		return new Ticket(id, fechaIngreso, fechaSalida, vehiculo);
	}

}
