package co.com.ceiba.adn.estacionamiento.dominio.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoVehiculo {

	private int id;
	private String nombre;
	private String descripcion;
	private float valorHora;
	private float valorDia;
	private int cantidadMaxima;
	
	public TipoVehiculo(int id) {
		this.id = id;
	}
	
	
}
