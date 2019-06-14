package co.com.ceiba.dna.parking.infraestructure.adapter.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.ceiba.dna.parking.infraestructure.adapter.entity.VehicleEntity;

@Repository
public interface VehicleRepositoryJPA extends CrudRepository<VehicleEntity, String> {

}
