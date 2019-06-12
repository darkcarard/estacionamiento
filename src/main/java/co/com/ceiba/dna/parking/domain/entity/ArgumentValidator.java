package co.com.ceiba.dna.parking.domain.entity;

import co.com.ceiba.dna.parking.domain.exception.ParkingException;

public class ArgumentValidator {

	private ArgumentValidator() {}
	
	public static void requiredValidation(Object value, String message) {
		if(value == null) {
			throw new ParkingException(message);
		}
	}
	
	public static void greaterThanZeroValidation(int value, String message) {
		if(value <= 0) {
			throw new ParkingException(message);
		}
	}
}
