package co.com.ceiba.dna.parking.domain.entity;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import co.com.ceiba.dna.parking.domain.exception.ParkingException;

public class EstacionamientoValidator {

	private static final String PLACA_FILTRO = "A";

	private EstacionamientoValidator() {
	}

	public static void validarCupo(long cantidadActual, int cantidadMaxima, String mensaje) {
		if (cantidadActual >= cantidadMaxima) {
			throw new ParkingException(mensaje);
		}
	}

	public static void validarIngresoPorPlaca(String placa, LocalDateTime fechaIngreso, String mensaje) {
		boolean result = placa.startsWith(PLACA_FILTRO) && !(fechaIngreso.getDayOfWeek().equals(DayOfWeek.SUNDAY)
				|| fechaIngreso.getDayOfWeek().equals(DayOfWeek.MONDAY));

		if (result) {
			throw new ParkingException(mensaje);
		}
	}

}
