package co.com.ceiba.dna.parking.domain.entity;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Parking {

	private static final String FULL_CAPACITY_MESSAGE = "Ya no hay cupo para el tipo de vehículo";
	private static final String UNAUTHORIZED_MESSAGE = "El vehículo no está autorizado para ingresar al estacionamiento el día de hoy";

	private List<Ticket> tickets;

	public Parking(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Ticket vehicleCheckIn(Vehicle vehicle, LocalDateTime entryDate) {

		ParkingValidator.capacityValidation(countVehiclesByType(vehicle.getVehicleType()),
				vehicle.getVehicleType().getMaxQuantity(), FULL_CAPACITY_MESSAGE);
		ParkingValidator.checkInByLicensePlateValidation(vehicle.getLicensePlate(), entryDate, UNAUTHORIZED_MESSAGE);

		Ticket ticket = new Ticket();
		ticket.setEntryDate(entryDate);
		ticket.setVehicle(vehicle);

		tickets.add(ticket);

		return ticket;

	}

	public float calculatePrice(Ticket ticket) {
		
		LocalDateTime tempDateTime = LocalDateTime.from(ticket.getEntryDate());
		long days = tempDateTime.until( ticket.getExitDate(), ChronoUnit.DAYS);
		tempDateTime = tempDateTime.plusDays( days );
		long hours = tempDateTime.until( ticket.getExitDate(), ChronoUnit.HOURS);
		float price = hours * ticket.getVehicle().getVehicleType().getHourPrice() + days * ticket.getVehicle().getVehicleType().getDayPrice();
		
		if (ticket.getVehicle().getVehicleType().equals(VehicleTypeEnum.MOTORCYCLE)
				&& ticket.getVehicle().getCylinderCapacity() > 500) {
			price += 2000F;
		}
		
		return price;
	}

	private long countVehiclesByType(VehicleTypeEnum vehicleType) {
		return tickets.stream().filter(t -> t.getVehicle().getVehicleType().equals(vehicleType)).count();
	}
}
