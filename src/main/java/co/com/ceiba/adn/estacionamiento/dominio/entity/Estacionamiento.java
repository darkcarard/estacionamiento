package co.com.ceiba.adn.estacionamiento.dominio.entity;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estacionamiento {

	private static final String MENSAJE_CUPO_LLENO = "Ya no hay cupo para el tipo de vehículo";
	private static final String MENSAJE_INGRESO_PLACA_NO_AUTORIZADA = "El vehículo no está autorizado para ingresar al estacionamiento el día de hoy";

	private List<Ticket> tickets;

	public Ticket ingresarVehiculo(Vehiculo vehiculo, LocalDateTime fechaIngreso) {

		EstacionamientoValidator.validarCupo(obtenerCantidadXTipoVehiculo(vehiculo.getTipo()),
				vehiculo.getTipo().getCantidadMaxima(), MENSAJE_CUPO_LLENO);
		EstacionamientoValidator.validarIngresoPorPlaca(vehiculo.getPlaca(), fechaIngreso,
				MENSAJE_INGRESO_PLACA_NO_AUTORIZADA);

		Ticket ticket = new Ticket();
		ticket.setFechaIngreso(fechaIngreso);
		ticket.setVehiculo(vehiculo);

		return ticket;

	}

	private long obtenerCantidadXTipoVehiculo(TipoVehiculoEnum tipoVehiculo) {
		return tickets.stream().filter(t -> t.getVehiculo().getTipo().equals(tipoVehiculo)).count();
	}
}
