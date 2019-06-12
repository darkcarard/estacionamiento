package co.com.ceiba.dna.parking.domain.entity;

import co.com.ceiba.dna.parking.domain.exception.ParkingException;

public class ArgumentValidator {

	private ArgumentValidator() {}
	
	public static void requiredValidation(Object valor, String mensaje) {
		if(valor == null) {
			throw new ParkingException(mensaje);
		}
	}
	
	public static void greaterThanZeroValidation(int valor, String mensaje) {
		if(valor <= 0) {
			throw new ParkingException(mensaje);
		}
	}
}
