package co.com.ceiba.adn.estacionamiento.infraestructura.adapter.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import co.com.ceiba.adn.estacionamiento.dominio.entity.TipoVehiculoEnum;

@Entity
@Table(name = "vehiculo")
public class VehiculoEntity {

	@Id
	private String placa;

	private int cilindraje;

	@Enumerated(EnumType.STRING)
	private TipoVehiculoEnum tipo;

	@OneToMany(mappedBy = "vehiculo")
	private List<TicketEntity> tickets;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

	public TipoVehiculoEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoVehiculoEnum tipo) {
		this.tipo = tipo;
	}

	public List<TicketEntity> getTickets() {
		return this.tickets;
	}

	public void setTickets(List<TicketEntity> tickets) {
		this.tickets = tickets;
	}

	public TicketEntity addTicket(TicketEntity ticket) {
		getTickets().add(ticket);
		ticket.setVehiculo(this);

		return ticket;
	}

	public TicketEntity removeTicket(TicketEntity ticket) {
		getTickets().remove(ticket);
		ticket.setVehiculo(null);

		return ticket;
	}
}
