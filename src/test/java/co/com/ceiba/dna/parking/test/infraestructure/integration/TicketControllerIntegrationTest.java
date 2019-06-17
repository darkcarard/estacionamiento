package co.com.ceiba.dna.parking.test.infraestructure.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import co.com.ceiba.dna.parking.Application;
import co.com.ceiba.dna.parking.domain.entity.Ticket;
import co.com.ceiba.dna.parking.domain.entity.Vehicle;
import co.com.ceiba.dna.parking.test.domain.databuilder.TicketTestDataBuilder;
import co.com.ceiba.dna.parking.test.domain.databuilder.VehicleTestDataBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.yaml")
public class TicketControllerIntegrationTest {

	private static final int DEFAULT_ID = 1;
	private static final LocalDateTime DEFAULT_ENTRY_DATE = LocalDateTime.now();
	private static final Vehicle DEFAULT_VEHICLE = new VehicleTestDataBuilder().build();

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;
	private Ticket ticket;
	private ObjectWriter objectWriter;

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
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
		mvc.perform(post("/tickets").contentType(MediaType.APPLICATION_JSON_UTF8).content(ticketJson)).andDo(print())
				.andExpect(status().is2xxSuccessful());
	}

	@Test
	public void findAllTickets() throws Exception {
		mvc.perform(get("/tickets").contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().is2xxSuccessful());
	}

}
