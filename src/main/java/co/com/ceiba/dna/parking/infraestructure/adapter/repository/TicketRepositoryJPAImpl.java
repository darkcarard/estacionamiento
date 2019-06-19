package co.com.ceiba.dna.parking.infraestructure.adapter.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.ceiba.dna.parking.domain.entity.Ticket;
import co.com.ceiba.dna.parking.domain.repository.TicketRepository;
import co.com.ceiba.dna.parking.infraestructure.adapter.entity.TicketEntity;
import co.com.ceiba.dna.parking.infraestructure.adapter.mapper.TicketMapper;

@Transactional
public class TicketRepositoryJPAImpl implements TicketRepository {

	@Autowired
	private TicketRepositoryJPA ticketRepository;  
	
	@Override
	public Ticket save(Ticket ticket) {
		return TicketMapper.toDomain(ticketRepository.save(TicketMapper.toEntity(ticket)));
	}

	@Override
	public List<Ticket> findAllTickets() {
		return TicketMapper.toDomain(ticketRepository.findAll());
	}

	@Override
	public Ticket findTicketById(int ticketId) {
		return TicketMapper.toDomain(ticketRepository.findById(ticketId).orElse(new TicketEntity()));
	}

}
