package co.com.ceiba.adn.estacionamiento.dominio.entity;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Estacionamiento {

	private int id;
	private Date fechaIngreso;
	private Date fechaSalida;
	private List<Vehiculo> vehiculos;
	
	public boolean validarCupo(ConfiguracionEstacionamiento configuracionEstacionamiento, TipoVehiculo tipoVehiculo) {
		
		long cantidad = vehiculos.stream().filter(v -> v.getTipo().equals(tipoVehiculo)).count();
		
		return cantidad <= tipoVehiculo.getCantidadMaxima();
	}



	
	
}
