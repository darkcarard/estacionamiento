package co.com.ceiba.dna.parking.infraestructure.adapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.ceiba.dna.parking.infraestructure.adapter.entity.TicketEntity;

public interface EstacionamientoRepositoryJPA extends JpaRepository<TicketEntity, Integer> {

}
