package co.com.ceiba.adn.estacionamiento.infraestructura.adapter.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "estacionamiento")
public class EstacionamientoEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_ingreso")
	private Date fechaIngreso;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_salida")
	private Date fechaSalida;

	@OneToMany(mappedBy="estacionamiento")
	private List<VehiculoEntity> vehiculos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public List<VehiculoEntity> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(List<VehiculoEntity> vehiculos) {
		this.vehiculos = vehiculos;
	}
	
	public VehiculoEntity addVehiculo(VehiculoEntity vehiculo) {
		getVehiculos().add(vehiculo);
		vehiculo.setEstacionamiento(this);

		return vehiculo;
	}

	public VehiculoEntity removeVehiculo(VehiculoEntity vehiculo) {
		getVehiculos().remove(vehiculo);
		vehiculo.setEstacionamiento(null);

		return vehiculo;
	}

}
