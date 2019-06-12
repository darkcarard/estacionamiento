package co.com.ceiba.dna.parking.test.domain.unit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.dna.parking.domain.entity.VehicleTypeEnum;
import co.com.ceiba.dna.parking.domain.entity.Vehicle;
import co.com.ceiba.dna.parking.domain.exception.ParkingException;
import co.com.ceiba.dna.parking.test.domain.TestBase;
import co.com.ceiba.dna.parking.test.domain.databuilder.VehicleTestDataBuilder;

public class VehicleTest {

	private static final String LICENSE_PLATE= "ABC123";
	private static final int CYLINDER_CAPACITY = 1500;
	private static final VehicleTypeEnum VEHICLE_TYPE = VehicleTypeEnum.CAR;
	private static final String REQUIRED_LICENSE_PLATE_MESSAGE = "El número de placa es obligatorio";
	private static final String CYLINDER_CAPACITY_GREATER_THAN_ZERO_MESSAGE = "El cilindraje no puede ser cero o negativo";
	private static final String REQUIRED_VEHICULE_TYPE_MESSAGE = "El tipo del vehículo es obligatorio";

	private Vehicle vehicle;

	@Before
	public void setUp() {

		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder().withLicensePlate(LICENSE_PLATE)
				.withCylinderCapacity(CYLINDER_CAPACITY).withVehicleType(VEHICLE_TYPE);
		vehicle = vehicleTestDataBuilder.build();
	}

	@Test
	public void vehicleBuild() {
		assertEquals(LICENSE_PLATE, vehicle.getLicensePlate());
	}

	@Test
	public void requiredLicensePlate() {
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder().withLicensePlate(null);
		TestBase.assertThrows(vehicleTestDataBuilder::build, ParkingException.class,
				REQUIRED_LICENSE_PLATE_MESSAGE);
	}

	@Test
	public void requiredCylinderCapacity() {
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder().withCylinderCapacity(0);
		TestBase.assertThrows(vehicleTestDataBuilder::build, ParkingException.class,
				CYLINDER_CAPACITY_GREATER_THAN_ZERO_MESSAGE);
	}

	@Test
	public void requiredVehicleType() {
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder().withVehicleType(null);
		TestBase.assertThrows(vehicleTestDataBuilder::build, ParkingException.class,
				REQUIRED_VEHICULE_TYPE_MESSAGE);
	}

}
