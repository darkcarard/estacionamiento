package co.com.ceiba.dna.parking.infraestructure.adapter.repository;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.ceiba.dna.parking.domain.entity.Ticket;
import co.com.ceiba.dna.parking.domain.repository.TicketRepository;
import co.com.ceiba.dna.parking.infraestructure.adapter.mapper.TicketMapper;

public class TicketRepositoryJPAImpl implements TicketRepository {

	@Autowired
	private TicketRepositoryJPA ticketRepository;  
	
	@Override
	public Ticket save(Ticket ticket) {
		return TicketMapper.toDomain(ticketRepository.save(TicketMapper.toEntity(ticket)));
	}

}
