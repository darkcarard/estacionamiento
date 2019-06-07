package co.com.ceiba.adn.estacionamiento.dominio.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoVehiculo {

	private byte id;
	private String nombre;
	private float valorHora;
	private float valorDia;
	private int cantidadMaxima;
	
	public TipoVehiculo(byte id) {
		this.id = id;
	}
	
	
}
