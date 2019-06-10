package co.com.ceiba.adn.estacionamiento.dominio.entity;

public enum TipoVehiculoEnum {
	
	CARRO("Carro", 1000F, 8000F, 20),
	MOTO("Moto", 500F, 4000F, 10);
	
	private final String nombre;
	private final float valorHora;
	private final float valorDia;
	private final int cantidadMaxima;
	
	private TipoVehiculoEnum(String nombre, float valorHora, float valorDia, int cantidadMaxima) {
		this.nombre = nombre;
		this.valorHora = valorHora;
		this.valorDia = valorDia;
		this.cantidadMaxima = cantidadMaxima;
	}

	public String getNombre() {
		return nombre;
	}

	public float getValorHora() {
		return valorHora;
	}

	public float getValorDia() {
		return valorDia;
	}

	public int getCantidadMaxima() {
		return cantidadMaxima;
	}
	
}