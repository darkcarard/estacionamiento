package co.com.ceiba.adn.estacionamiento.dominio.exception;

public class EstacionamientoException extends RuntimeException {

	private static final long serialVersionUID = -2543098941823417639L;

	public EstacionamientoException(String mensaje) {
		
		super(mensaje);
	}
}
