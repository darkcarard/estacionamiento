package co.com.ceiba.adn.estacionamiento.dominio.entity;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Estacionamiento {

	private int id;
	private List<Vehiculo> vehiculos;
	private Date fechaIngreso;
	private Date fechaSalida;
}
