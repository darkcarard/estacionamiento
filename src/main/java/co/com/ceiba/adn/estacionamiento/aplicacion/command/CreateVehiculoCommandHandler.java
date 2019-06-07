package co.com.ceiba.adn.estacionamiento.aplicacion.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ceiba.adn.estacionamiento.dominio.entity.Vehiculo;
import co.com.ceiba.adn.estacionamiento.dominio.port.VehiculoRepository;

@Component
public class CreateVehiculoCommandHandler {

	private VehiculoRepository repository;

	@Autowired
	public CreateVehiculoCommandHandler(VehiculoRepository repository) {
		this.repository = repository;
	}
	
	public void handler(Vehiculo vehiculo) {
		
		repository.save(vehiculo);
	}
	
}
