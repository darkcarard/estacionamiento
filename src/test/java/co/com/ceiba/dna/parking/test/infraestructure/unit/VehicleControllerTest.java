package co.com.ceiba.dna.parking.test.infraestructure.unit;

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

import co.com.ceiba.dna.parking.application.command.CreateVehicleCommandHandler;
import co.com.ceiba.dna.parking.domain.entity.Vehicle;
import co.com.ceiba.dna.parking.domain.entity.VehicleTypeEnum;
import co.com.ceiba.dna.parking.domain.repository.VehicleRepository;
import co.com.ceiba.dna.parking.infraestructure.controller.VehicleController;
import co.com.ceiba.dna.parking.test.domain.databuilder.VehicleTestDataBuilder;

@RunWith(SpringRunner.class)
@WebMvcTest(VehicleController.class)
public class VehicleControllerTest {

	private static final String DEFAULT_LICENSE_PLATE = "BCD123";
	private static final int DEFAULT_CYLINDER_CAPACITY = 1500;
	private static final VehicleTypeEnum DEFAULT_VEHICLE_TYPE = VehicleTypeEnum.CAR;

	private ObjectWriter objectWriter;
	private Vehicle vehicle;

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private VehicleRepository vehicleRepository;

	@MockBean
	private CreateVehicleCommandHandler createVehicleCommandHandler;

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
	public void saveVehicleTest() throws Exception {

		String vehicleJson = objectWriter.writeValueAsString(vehicle);

		mockMvc.perform(post("/vehiculos").contentType(MediaType.APPLICATION_JSON_UTF8).content(vehicleJson))
				.andDo(print()).andExpect(status().isOk());
	}

}
