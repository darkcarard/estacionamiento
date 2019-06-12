package co.com.ceiba.dna.parking.infraestructure.adapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.ceiba.dna.parking.infraestructure.adapter.entity.VehicleEntity;

public interface TipoVehiculoRepositoryJPA extends JpaRepository<VehicleEntity, String> {

}
