package co.com.ceiba.adn.estacionamiento.infraestructura.adapter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_vehiculo")
public class TipoVehiculoEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private byte id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "valor_hora")
	private float valorHora;
	
	@Column(name = "valor_dia")
	private float valorDia;
	
	@Column(name = "cantidad_maxima")
	private int cantidadMaxima;

	public TipoVehiculoEntity() {
	
	}

	public TipoVehiculoEntity(byte id, String nombre, float valorHora, float valorDia,
			int cantidadMaxima) {
		this.id = id;
		this.nombre = nombre;
		this.valorHora = valorHora;
		this.valorDia = valorDia;
		this.cantidadMaxima = cantidadMaxima;
	}

	public byte getId() {
		return id;
	}

	public void setId(byte id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getValorHora() {
		return valorHora;
	}

	public void setValorHora(float valorHora) {
		this.valorHora = valorHora;
	}

	public float getValorDia() {
		return valorDia;
	}

	public void setValorDia(float valorDia) {
		this.valorDia = valorDia;
	}

	public int getCantidadMaxima() {
		return cantidadMaxima;
	}

	public void setCantidadMaxima(int cantidadMaxima) {
		this.cantidadMaxima = cantidadMaxima;
	}
	
}
