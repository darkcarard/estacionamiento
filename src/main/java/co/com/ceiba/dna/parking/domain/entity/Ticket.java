package co.com.ceiba.dna.parking.domain.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

	private int id;
	private LocalDateTime fechaIngreso;
	private LocalDateTime fechaSalida;
	private Vehicle vehiculo;
	
}
