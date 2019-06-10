package co.com.ceiba.adn.estacionamiento.dominio.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

	private int id;
	private Date fechaIngreso;
	private Date fechaSalida;
	private Vehiculo vehiculo;
	
}
