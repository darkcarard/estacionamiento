package co.com.ceiba.adn.estacionamiento.dominio.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estacionamiento {

	private static final String MENSAJE_CUPO_LLENO = "Ya no hay cupo para el tipo de vehículo";

	private List<Ticket> tickets;

	public void ingresarVehiculo(Vehiculo vehiculo) {

		EstacionamientoValidator.validarCupo(obtenerCantidadXTipoVehiculo(vehiculo.getTipo()),
				vehiculo.getTipo().getCantidadMaxima(), MENSAJE_CUPO_LLENO);
	}

	public long obtenerCantidadXTipoVehiculo(TipoVehiculoEnum tipoVehiculo) {

		return tickets.stream().filter(t -> t.getVehiculo().getTipo().equals(tipoVehiculo)).count();
	}

}
