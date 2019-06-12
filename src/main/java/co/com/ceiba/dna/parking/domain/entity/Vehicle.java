package co.com.ceiba.dna.parking.domain.entity;

import java.util.List;

import co.com.ceiba.dna.parking.infraestructure.adapter.entity.TicketEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Vehicle {

	private String placa;
	private int cylinderCapacity;
	private VehicleTypeEnum tipo;
	private List<TicketEntity> tickets;

	public Vehicle(String placa, int cilindraje, VehicleTypeEnum tipo) {
		
		ArgumentValidator.requiredValidation(placa, "El número de placa es obligatorio");
		ArgumentValidator.greaterThanZeroValidation(cilindraje, "El cilindraje no puede ser cero o negativo");
		ArgumentValidator.requiredValidation(tipo, "El tipo del vehículo es obligatorio");
		
		this.placa = placa;
		this.cylinderCapacity = cilindraje;
		this.tipo = tipo;
	}
	
}
