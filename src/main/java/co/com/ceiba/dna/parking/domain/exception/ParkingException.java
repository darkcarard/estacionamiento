package co.com.ceiba.dna.parking.domain.exception;

public class ParkingException extends RuntimeException {

	private static final long serialVersionUID = -2543098941823417639L;

	public ParkingException(String mensaje) {
		
		super(mensaje);
	}
}
