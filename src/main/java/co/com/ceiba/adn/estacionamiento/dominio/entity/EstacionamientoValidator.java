package co.com.ceiba.adn.estacionamiento.dominio.entity;

import co.com.ceiba.adn.estacionamiento.dominio.exception.EstacionamientoException;

public class EstacionamientoValidator {
	
	private EstacionamientoValidator( ) {}
	
	public static void validarCupo(long cantidadActual, int cantidadMaxima, String mensaje) {
		if (cantidadActual >= cantidadMaxima) {
			throw new EstacionamientoException(mensaje);
		}
	}

}
