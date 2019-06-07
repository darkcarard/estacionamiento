package co.com.ceiba.adn.estacionamiento.dominio.entity;

public class Vehiculo {

	private String placa;
	private int cilindraje;
	private TipoVehiculo tipo;
	private Estacionamiento estacionamiento;
	
	public Vehiculo() {

	}

	public Vehiculo(String placa, int cilindraje, TipoVehiculo tipo) {
		
		ArgumentoValidator.validarRequerido(placa, "El número de placa es obligatorio");
		ArgumentoValidator.validarRequerido(cilindraje, "El cilindraje del vehículo es obligatorio");
		ArgumentoValidator.validarRequerido(tipo, "El tipo del vehículo es obligatorio");
		
		this.placa = placa;
		this.cilindraje = cilindraje;
		this.tipo = tipo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

	public TipoVehiculo getTipo() {
		return tipo;
	}

	public void setTipo(TipoVehiculo tipo) {
		this.tipo = tipo;
	}

	public Estacionamiento getEstacionamiento() {
		return estacionamiento;
	}

	public void setEstacionamiento(Estacionamiento estacionamiento) {
		this.estacionamiento = estacionamiento;
	}
	
}
