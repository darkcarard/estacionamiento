package co.com.ceiba.dna.parking.infraestructure.adapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ceiba.dna.parking.infraestructure.adapter.entity.VehicleEntity;

@Repository
public interface VehicleRepositoryJPA extends JpaRepository<VehicleEntity, String> {

}
