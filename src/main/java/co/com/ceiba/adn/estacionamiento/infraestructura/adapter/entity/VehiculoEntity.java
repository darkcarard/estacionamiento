package co.com.ceiba.adn.estacionamiento.infraestructura.adapter.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vehiculo")
public class VehiculoEntity {

	@Id
	@Column
	private String placa;

	@Column(name = "cilindraje")
	private int cilindraje;

	@ManyToOne
	@JoinColumn(name="tipo")
	private TipoVehiculoEntity tipo;

	@OneToMany(mappedBy="vehiculo")
	private List<EstacionamientoEntity> estacionamientos;
	
	public VehiculoEntity() {
		
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

	public TipoVehiculoEntity getTipo() {
		return tipo;
	}

	public void setTipo(TipoVehiculoEntity tipo) {
		this.tipo = tipo;
	}

	public List<EstacionamientoEntity> getEstacionamientos() {
		return estacionamientos;
	}

	public void setEstacionamientos(List<EstacionamientoEntity> estacionamientos) {
		this.estacionamientos = estacionamientos;
	}

}
