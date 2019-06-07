package co.com.ceiba.adn.estacionamiento.infraestructura.adapter.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "configuracion_estacionamiento")
@Data
public class ConfiguracionEstacionamientoEntity implements Serializable {
	
	private static final long serialVersionUID = -2594288359271499956L;

	@Id
	@OneToOne
	@JoinColumn(name = "id")
	private TipoVehiculoEntity tipoVehiculo;
	
	@Column(name = "cantidad_actual")
	private int cantidadActual;
}
