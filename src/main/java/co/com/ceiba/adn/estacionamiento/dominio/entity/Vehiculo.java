package co.com.ceiba.adn.estacionamiento.dominio.entity;

import java.util.List;

import co.com.ceiba.adn.estacionamiento.infraestructura.adapter.entity.TicketEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Vehiculo {

	private String placa;
	private int cilindraje;
	private TipoVehiculoEnum tipo;
	private List<TicketEntity> tickets;

	public Vehiculo(String placa, int cilindraje, TipoVehiculoEnum tipo) {
		
		ArgumentoValidator.validarRequerido(placa, "El número de placa es obligatorio");
		ArgumentoValidator.validarMayorACero(cilindraje, "El cilindraje no puede ser cero o negativo");
		ArgumentoValidator.validarRequerido(tipo, "El tipo del vehículo es obligatorio");
		
		this.placa = placa;
		this.cilindraje = cilindraje;
		this.tipo = tipo;
	}
	
}
