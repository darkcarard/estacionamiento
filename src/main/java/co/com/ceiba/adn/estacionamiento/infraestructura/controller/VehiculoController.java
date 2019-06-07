package co.com.ceiba.adn.estacionamiento.infraestructura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.adn.estacionamiento.aplicacion.command.CreateVehiculoCommandHandler;
import co.com.ceiba.adn.estacionamiento.dominio.entity.Vehiculo;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

	private CreateVehiculoCommandHandler createVehiculoCommandHandler;

	public CreateVehiculoCommandHandler getCreateVehiculoCommandHandler() {
		return createVehiculoCommandHandler;
	}

	@Autowired
	public void setCreateVehiculoCommandHandler(CreateVehiculoCommandHandler createVehiculoCommandHandler) {
		this.createVehiculoCommandHandler = createVehiculoCommandHandler;
	}

	@PostMapping
	public void save(@RequestBody Vehiculo vehiculo) {
		createVehiculoCommandHandler.handler(vehiculo);
	}
	
}
