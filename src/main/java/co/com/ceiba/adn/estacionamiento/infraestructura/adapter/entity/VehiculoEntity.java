package co.com.ceiba.adn.estacionamiento.infraestructura.adapter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vehiculo")
public class VehiculoEntity {

	@Id
	@Column(name = "placa")
	private String placa;

	@Column(name = "cilindraje")
	private int cilindraje;

	@OneToOne
	@JoinColumn(name="tipo")
	private TipoVehiculoEntity tipo;

	@ManyToOne
	@JoinColumn(name="id")
	private EstacionamientoEntity estacionamiento;

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

	public TipoVehiculoEntity getTipo() {
		return tipo;
	}

	public void setTipo(TipoVehiculoEntity tipo) {
		this.tipo = tipo;
	}

	public EstacionamientoEntity getEstacionamiento() {
		return estacionamiento;
	}

	public void setEstacionamiento(EstacionamientoEntity estacionamiento) {
		this.estacionamiento = estacionamiento;
	}
}
