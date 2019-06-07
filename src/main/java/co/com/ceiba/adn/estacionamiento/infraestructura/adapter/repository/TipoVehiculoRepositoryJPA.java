package co.com.ceiba.adn.estacionamiento.infraestructura.adapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.ceiba.adn.estacionamiento.infraestructura.adapter.entity.VehiculoEntity;

public interface TipoVehiculoRepositoryJPA extends JpaRepository<VehiculoEntity, String> {

}
