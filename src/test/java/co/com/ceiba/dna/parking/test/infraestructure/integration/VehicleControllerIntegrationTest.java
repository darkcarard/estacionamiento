package co.com.ceiba.dna.parking.test.infraestructure.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import co.com.ceiba.dna.parking.Application;
import co.com.ceiba.dna.parking.domain.entity.Vehicle;
import co.com.ceiba.dna.parking.domain.entity.VehicleTypeEnum;
import co.com.ceiba.dna.parking.test.domain.databuilder.VehicleTestDataBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.yaml")
public class VehicleControllerIntegrationTest {

	private static final String DEFAULT_LICENSE_PLATE = "BCD123";
	private static final int DEFAULT_CYLINDER_CAPACITY = 1500;
	private static final VehicleTypeEnum DEFAULT_VEHICLE_TYPE = VehicleTypeEnum.CAR;

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;
	private Vehicle vehicle;

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder()
				.withLicensePlate(DEFAULT_LICENSE_PLATE).withCylinderCapacity(DEFAULT_CYLINDER_CAPACITY)
				.withVehicleType(DEFAULT_VEHICLE_TYPE);
		vehicle = vehicleTestDataBuilder.build();
	}

	@Test
	public void saveVehicleTest() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();

		String vehicleJson = ow.writeValueAsString(vehicle);

		mvc.perform(post("/vehiculos").contentType(MediaType.APPLICATION_JSON_UTF8).content(vehicleJson)).andDo(print())
				.andExpect(status().is2xxSuccessful());
	}

	@Test
	public void findAllVehiclesTest() throws Exception {
		mvc.perform(get("/vehiculos").contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().is2xxSuccessful());
	}
}
