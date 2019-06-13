package co.com.ceiba.dna.parking.test.infraestructure.unit;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
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

@RunWith(SpringRunner.class)
@WebMvcTest(VehicleController.class)
public class VehicleControllerTest {

	private static final String DEFAULT_LICENSE_PLATE = "BCD123";
	private static final int DEFAULT_CYLINDER_CAPACITY = 1500;
	private static final VehicleTypeEnum DEFAULT_VEHICLE_TYPE = VehicleTypeEnum.CAR;
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private VehicleRepository vehicleRepository;
	
	@MockBean
	private CreateVehicleCommandHandler createVehicleCommandHandler; 

	@Test
	public void saveVehicleTest() throws Exception {

		Vehicle vehicle = new Vehicle(DEFAULT_LICENSE_PLATE, DEFAULT_CYLINDER_CAPACITY, DEFAULT_VEHICLE_TYPE);

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		
		String vehicleJson = ow.writeValueAsString(vehicle);
		
		mockMvc.perform(post("/vehiculos")
				 .contentType(MediaType.APPLICATION_JSON_UTF8)
		         .content(vehicleJson))
		         .andDo(print())
		         .andExpect(status().isOk());
	}

}
