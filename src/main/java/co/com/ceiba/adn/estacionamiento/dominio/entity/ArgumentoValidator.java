package co.com.ceiba.adn.estacionamiento.dominio.entity;

import co.com.ceiba.adn.estacionamiento.dominio.exception.EstacionamientoException;

public class ArgumentoValidator {

	private ArgumentoValidator() {}
	
	public static void validarRequerido(Object valor, String mensaje) {
		if(valor == null) {
			throw new EstacionamientoException(mensaje);
		}
	}
	
	public static void validarMayorACero(int valor, String mensaje) {
		if(valor <= 0) {
			throw new EstacionamientoException(mensaje);
		}
	}
}
