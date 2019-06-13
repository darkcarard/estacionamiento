package co.com.ceiba.dna.parking.infraestructure.adapter.repository;

import org.springframework.data.repository.CrudRepository;

import co.com.ceiba.dna.parking.infraestructure.adapter.entity.VehicleEntity;

public interface VehiculoRepositoryJPA extends CrudRepository<VehicleEntity, Integer> {

}
