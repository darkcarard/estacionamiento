package co.com.ceiba.adn.estacionamiento.infraestructura.adapter.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.ceiba.adn.estacionamiento.infraestructura.adapter.entity.VehiculoEntity;

@Repository
public interface VehiculoRepositoryJPA extends CrudRepository<VehiculoEntity, Integer> {

}
