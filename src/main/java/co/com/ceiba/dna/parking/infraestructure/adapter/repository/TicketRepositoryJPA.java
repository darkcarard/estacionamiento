package co.com.ceiba.dna.parking.infraestructure.adapter.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.ceiba.dna.parking.infraestructure.adapter.entity.TicketEntity;

@Repository
public interface TicketRepositoryJPA extends CrudRepository<TicketEntity, Integer> {

}
