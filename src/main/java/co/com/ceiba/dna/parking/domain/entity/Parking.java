package co.com.ceiba.dna.parking.domain.entity;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Parking {

	private static final String FULL_CAPACITY_MESSAGE = "Ya no hay cupo para el tipo de vehículo";
	private static final String UNAUTHORIZED_MESSAGE = "El vehículo no está autorizado para ingresar al estacionamiento el día de hoy";

	private List<Ticket> tickets;

	public Ticket vehiculeCheckIn(Vehicle vehicle, LocalDateTime entryDate) {

		EstacionamientoValidator.validarCupo(countVehiclesByType(vehicle.getTipo()),
				vehicle.getTipo().getCantidadMaxima(), FULL_CAPACITY_MESSAGE);
		EstacionamientoValidator.validarIngresoPorPlaca(vehicle.getPlaca(), entryDate,
				UNAUTHORIZED_MESSAGE);

		Ticket ticket = new Ticket();
		ticket.setFechaIngreso(entryDate);
		ticket.setVehiculo(vehicle);

		tickets.add(ticket);
		
		return ticket;

	}

	private long countVehiclesByType(VehicleTypeEnum vehicleType) {
		return tickets.stream().filter(t -> t.getVehiculo().getTipo().equals(vehicleType)).count();
	}
}
