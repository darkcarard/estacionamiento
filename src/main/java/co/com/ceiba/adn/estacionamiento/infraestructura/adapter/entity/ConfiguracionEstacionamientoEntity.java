package co.com.ceiba.adn.estacionamiento.infraestructura.adapter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "configuracion_estacionamiento")
@Data
public class ConfiguracionEstacionamientoEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private byte id;
	
	@OneToOne
	@JoinColumn(name="tipo_vehiculo")
	private TipoVehiculoEntity tipoVehiculo;
	
	@Column(name = "cantidad_actual")
	private int cantidadActual;
}
