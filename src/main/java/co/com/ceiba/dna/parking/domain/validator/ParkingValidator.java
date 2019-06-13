package co.com.ceiba.dna.parking.domain.validator;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import co.com.ceiba.dna.parking.domain.exception.ParkingException;

public final class ParkingValidator {

	private static final String LICENSE_PLATE_FILTER = "A";

	private ParkingValidator() {
	}

	public static void capacityValidation(long actualQuantity, int maxQuantity, String message) {
		if (actualQuantity >= maxQuantity) {
			throw new ParkingException(message);
		}
	}

	public static void checkInByLicensePlateValidation(String licensePlate, LocalDateTime entryDate, String message) {
		if (licensePlate.startsWith(LICENSE_PLATE_FILTER) && !(entryDate.getDayOfWeek().equals(DayOfWeek.SUNDAY)
				|| entryDate.getDayOfWeek().equals(DayOfWeek.MONDAY))) {
			throw new ParkingException(message);
		}
	}

}
