package co.com.ceiba.adn.estacionamiento.dominio.entity;

import lombok.Data;

@Data
public class ConfiguracionEstacionamiento {

	private byte id;
	private TipoVehiculo tipoVehiculo;
	private int cantidadActual;
}
