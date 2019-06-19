package co.com.ceiba.dna.parking.test.infraestructure.unit;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import co.com.ceiba.dna.parking.application.service.ParkingService;
import co.com.ceiba.dna.parking.domain.entity.Vehicle;
import co.com.ceiba.dna.parking.domain.entity.VehicleTypeEnum;
import co.com.ceiba.dna.parking.infraestructure.controller.ParkingController;
import co.com.ceiba.dna.parking.test.domain.databuilder.VehicleTestDataBuilder;

@RunWith(SpringRunner.class)
@WebMvcTest(ParkingController.class)
public class ParkingControllerTest {

	private static final String DEFAULT_LICENSE_PLATE = "BCD123";
	private static final int DEFAULT_CYLINDER_CAPACITY = 1500;
	private static final VehicleTypeEnum DEFAULT_VEHICLE_TYPE = VehicleTypeEnum.CAR;
	private static final String DEFAULT_ENTRY_DATE = "2019-06-19 11:00";
	private static final int DEFAULT_TICKET_ID = 1;

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ParkingService parkingService;

	private ObjectWriter objectWriter;
	private Vehicle vehicle;

	@Before
	public void setUp() {
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder()
				.withLicensePlate(DEFAULT_LICENSE_PLATE).withCylinderCapacity(DEFAULT_CYLINDER_CAPACITY)
				.withVehicleType(DEFAULT_VEHICLE_TYPE);
		vehicle = vehicleTestDataBuilder.build();
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		objectWriter = mapper.writer().withDefaultPrettyPrinter();
	}

	@Test
	public void checkInVehicleTest() throws Exception {
		String vehicleJson = objectWriter.writeValueAsString(vehicle);
		mockMvc.perform(post("/parking/checkIn/" + DEFAULT_ENTRY_DATE).contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(vehicleJson)).andDo(print()).andExpect(status().is2xxSuccessful());
	}

	@Test
	public void calculatePrice() throws Exception {
		mockMvc.perform(get("/parking/price/" + DEFAULT_TICKET_ID).contentType(MediaType.APPLICATION_JSON_UTF8)).andDo(print())
				.andExpect(status().is2xxSuccessful());
	}

	@Test
	public void checkOutVehicle() throws Exception {
		mockMvc.perform(get("/parking/pay/" + DEFAULT_TICKET_ID).contentType(MediaType.APPLICATION_JSON_UTF8)).andDo(print())
		.andExpect(status().is2xxSuccessful());
	}
}
