package co.com.ceiba.dna.parking.test.infraestructure.unit;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import co.com.ceiba.dna.parking.application.service.TicketService;
import co.com.ceiba.dna.parking.domain.entity.Ticket;
import co.com.ceiba.dna.parking.domain.entity.Vehicle;
import co.com.ceiba.dna.parking.domain.repository.TicketRepository;
import co.com.ceiba.dna.parking.infraestructure.controller.TicketController;
import co.com.ceiba.dna.parking.test.domain.databuilder.TicketTestDataBuilder;
import co.com.ceiba.dna.parking.test.domain.databuilder.VehicleTestDataBuilder;

@RunWith(SpringRunner.class)
@WebMvcTest(TicketController.class)
public class TicketControllerTest {

	private static final int DEFAULT_ID = 1;
	private static final LocalDateTime DEFAULT_ENTRY_DATE = LocalDateTime.now();
	private static final Vehicle DEFAULT_VEHICLE = new VehicleTestDataBuilder().build();

	private Ticket ticket;
	private ObjectWriter objectWriter;

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TicketRepository ticketRepository;

	@MockBean
	private TicketService ticketService;

	@Before
	public void setUp() {
		TicketTestDataBuilder ticketTestDataBuilder = new TicketTestDataBuilder().withId(DEFAULT_ID)
				.withEntryDate(DEFAULT_ENTRY_DATE).withVehicle(DEFAULT_VEHICLE);
		ticket = ticketTestDataBuilder.build();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
	}

	@Test
	public void saveTicketTest() throws Exception {
		String ticketJson = objectWriter.writeValueAsString(ticket);
		
		mockMvc.perform(post("/tickets").contentType(MediaType.APPLICATION_JSON_UTF8).content(ticketJson))
				.andDo(print()).andExpect(status().is2xxSuccessful());
	}

}
