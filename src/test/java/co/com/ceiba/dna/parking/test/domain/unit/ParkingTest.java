package co.com.ceiba.dna.parking.test.domain.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.dna.parking.domain.entity.Parking;
import co.com.ceiba.dna.parking.domain.entity.Ticket;
import co.com.ceiba.dna.parking.domain.entity.Vehicle;
import co.com.ceiba.dna.parking.domain.entity.VehicleTypeEnum;
import co.com.ceiba.dna.parking.domain.exception.ParkingException;
import co.com.ceiba.dna.parking.test.domain.TestBase;
import co.com.ceiba.dna.parking.test.domain.databuilder.ParkingTestDataBuilder;
import co.com.ceiba.dna.parking.test.domain.databuilder.TicketTestDataBuilder;
import co.com.ceiba.dna.parking.test.domain.databuilder.VehicleTestDataBuilder;

public class ParkingTest {

	private static final LocalDateTime ENTRY_DATE = LocalDateTime.now();
	// Esta fecha es un domingo
	private static final LocalDateTime AUTHORIZED_ENTRY_DATE = LocalDateTime.of(2019, Month.JUNE, 9, 10, 0);
	// Esta fecha es un martes
	private static final LocalDateTime UNAUTHORIZED_ENTRY_DATE = LocalDateTime.of(2019, Month.JUNE, 11, 10, 0);
	private static final String LICENSE_PLATE_STARTING_WITH_A = "ABC123";
	private static final String LICENSE_PLATE_NOT_STARTING_WITH_A = "BCD123";
	private static final String FULL_CAPACITY_MESSAGE = "Ya no hay cupo para el tipo de vehículo";
	private static final String UNAUTHORIZED_ENTRY_MESSAGE = "El vehículo no está autorizado para ingresar al estacionamiento el día de hoy";
	private static final LocalDateTime ENTRY_DATE_8_HOURS = LocalDateTime.of(2019, Month.JUNE, 9, 10, 0);
	private static final LocalDateTime EXIT_DATE_8_HOURS = LocalDateTime.of(2019, Month.JUNE, 9, 18, 0);
	private static final LocalDateTime ENTRY_DATE_2_DAYS = LocalDateTime.of(2019, Month.JUNE, 9, 10, 0);
	private static final LocalDateTime EXIT_DATE_2_DAYS = LocalDateTime.of(2019, Month.JUNE, 11, 10, 0);
	private static final LocalDateTime ENTRY_DATE_1_DAY_3_HOURS = LocalDateTime.of(2019, Month.JUNE, 9, 10, 0);
	private static final LocalDateTime EXIT_DATE_1_DAY_3_HOURS = LocalDateTime.of(2019, Month.JUNE, 10, 13, 0);
	private static final float TAX_GREATER_500CC = 2000f;
	private static final float EXPECTED_PRICE_8_HOURS_CAR = 8000F;
	private static final float EXPECTED_PRICE_8_HOURS_MOTORCYCLE = 4000F;
	private static final float EXPECTED_PRICE_8_HOURS_MOTORCYCLE_GREATER_500CC = EXPECTED_PRICE_8_HOURS_MOTORCYCLE + TAX_GREATER_500CC;
	private static final float EXPECTED_PRICE_2_DAY_CAR = 16000F;
	private static final float EXPECTED_PRICE_2_DAY_MOTORCYCLE = 8000F;
	private static final float EXPECTED_PRICE_2_DAY_MOTORCYCLE_GREATER_500CC = EXPECTED_PRICE_2_DAY_MOTORCYCLE + TAX_GREATER_500CC;
	private static final float EXPECTED_PRICE_1_DAY_3_HOUR_CAR = 11000F;
	private static final float EXPECTED_PRICE_1_DAY_3_HOUR_MOTORCYCLE = 5500F;
	private static final float EXPECTED_PRICE_1_DAY_3_HOUR_MOTORCYCLE_GREATER_500CC = EXPECTED_PRICE_1_DAY_3_HOUR_MOTORCYCLE + TAX_GREATER_500CC;
	private static final int CYLINDER_CAPACITY_400 = 400;
	private static final int CYLINDER_CAPACITY_650 = 650;
	
	private ParkingTestDataBuilder parkingTestDataBuilder;
	private VehicleTestDataBuilder vehicleTestDataBuilder;
	private TicketTestDataBuilder ticketTestDataBuilder;
	private Parking parking;
	private Vehicle vehicle;
	private Ticket ticket;

	@Before
	public void setUp() {
		parkingTestDataBuilder = new ParkingTestDataBuilder();
		vehicleTestDataBuilder = new VehicleTestDataBuilder();
		ticketTestDataBuilder = new TicketTestDataBuilder();
		parking = parkingTestDataBuilder.build();
		vehicle = vehicleTestDataBuilder.build();
		ticket = ticketTestDataBuilder.build();
	}

	/**
	 * Probamos que al instanciar un estacionamiento la lista de tickets se
	 * instancie también
	 */
	@Test
	public void parkingBuild() {
		assertNotNull(parking);
	}

	/**
	 * Probamos que se cree un ticket correctamente al ingresar un vehículo y haya
	 * cupo para el tipo de vehículo
	 */
	@Test
	public void vehicleCheckInWithCapacity() {
		parking = parkingTestDataBuilder.build();
		vehicleTestDataBuilder = vehicleTestDataBuilder.withLicensePlate(LICENSE_PLATE_NOT_STARTING_WITH_A);
		vehicle = vehicleTestDataBuilder.build();
		ticket = parking.vehicleCheckIn(vehicle, AUTHORIZED_ENTRY_DATE);
		assertNotNull(ticket);
	}

	/**
	 * Probamos que se muestre un mensaje de error si no hay cupo para el tipo de
	 * vehículo
	 */
	@Test
	public void vehicleCheckInWithoutCapacity() {
		List<Ticket> tickets = new ArrayList<>();
		for (int i = 0; i < vehicle.getVehicleType().getMaxQuantity(); i++) {
			ticket = ticketTestDataBuilder.withId(i).withVehicle(vehicle).build();
			tickets.add(ticket);
		}
		parking = parkingTestDataBuilder.withTickets(tickets).build();
		TestBase.assertThrows(() -> parking.vehicleCheckIn(vehicle, ENTRY_DATE), ParkingException.class,
				FULL_CAPACITY_MESSAGE);

	}

	@Test
	public void vehicleCheckInWithLicensePlateAOnAuthorizedDay() {
		vehicleTestDataBuilder = vehicleTestDataBuilder.withLicensePlate(LICENSE_PLATE_STARTING_WITH_A);
		vehicle = vehicleTestDataBuilder.build();
		ticket = parking.vehicleCheckIn(vehicle, AUTHORIZED_ENTRY_DATE);
		assertNotNull(ticket);
	}

	@Test
	public void vehicleCheckInWithLicensePlateAOnUnauthorizedDay() {
		vehicleTestDataBuilder = vehicleTestDataBuilder.withLicensePlate(LICENSE_PLATE_STARTING_WITH_A);
		vehicle = vehicleTestDataBuilder.build();
		TestBase.assertThrows(() -> parking.vehicleCheckIn(vehicle, UNAUTHORIZED_ENTRY_DATE), ParkingException.class,
				UNAUTHORIZED_ENTRY_MESSAGE);
	}

	@Test
	public void vehicleCheckInWithLicensePlateNotAOnAuthorizedDay() {
		vehicleTestDataBuilder = vehicleTestDataBuilder.withLicensePlate(LICENSE_PLATE_NOT_STARTING_WITH_A)
				.withVehicleType(VehicleTypeEnum.MOTORCYCLE);
		vehicle = vehicleTestDataBuilder.build();
		ticket = parking.vehicleCheckIn(vehicle, AUTHORIZED_ENTRY_DATE);
		assertNotNull(ticket);
	}

	@Test
	public void vehicleCheckInWithLicensePlateNotAOnUnauthorizedDay() {
		vehicleTestDataBuilder = vehicleTestDataBuilder.withLicensePlate(LICENSE_PLATE_NOT_STARTING_WITH_A);
		vehicle = vehicleTestDataBuilder.build();
		ticket = parking.vehicleCheckIn(vehicle, UNAUTHORIZED_ENTRY_DATE);
		assertNotNull(ticket);
	}

	@Test
	public void vehicleCheckOutCalculatePrice8HoursCarWithoutRestriction() {
		vehicle = vehicleTestDataBuilder.withLicensePlate(LICENSE_PLATE_NOT_STARTING_WITH_A)
				.withVehicleType(VehicleTypeEnum.CAR).build();
		ticketTestDataBuilder = ticketTestDataBuilder.withEntryDate(ENTRY_DATE_8_HOURS)
				.withExitDate(EXIT_DATE_8_HOURS).withVehicle(vehicle);
		ticket = ticketTestDataBuilder.build();
		
		float price = parking.calculatePrice(ticket); 
		
		assertEquals(EXPECTED_PRICE_8_HOURS_CAR, price, 0F);
	}
	
	@Test
	public void vehicleCheckOutCalculatePrice8HoursMotorcycleWithoutRestriction() {
		vehicle = vehicleTestDataBuilder.withLicensePlate(LICENSE_PLATE_NOT_STARTING_WITH_A)
				.withVehicleType(VehicleTypeEnum.MOTORCYCLE).withCylinderCapacity(CYLINDER_CAPACITY_400).build();
		ticketTestDataBuilder = ticketTestDataBuilder.withEntryDate(ENTRY_DATE_8_HOURS)
				.withExitDate(EXIT_DATE_8_HOURS).withVehicle(vehicle);
		ticket = ticketTestDataBuilder.build();
		
		float price = parking.calculatePrice(ticket); 
		
		assertEquals(EXPECTED_PRICE_8_HOURS_MOTORCYCLE, price, 0F);
	}

	@Test
	public void vehicleCheckOutCalculatePrice2DaysCarWithoutRestriction() {
		vehicle = vehicleTestDataBuilder.withLicensePlate(LICENSE_PLATE_NOT_STARTING_WITH_A)
				.withVehicleType(VehicleTypeEnum.CAR).build();
		ticketTestDataBuilder = ticketTestDataBuilder.withEntryDate(ENTRY_DATE_2_DAYS)
				.withExitDate(EXIT_DATE_2_DAYS).withVehicle(vehicle);
		ticket = ticketTestDataBuilder.build();
		
		float price = parking.calculatePrice(ticket); 
		
		assertEquals(EXPECTED_PRICE_2_DAY_CAR, price, 0F);
	}
	
	@Test
	public void vehicleCheckOutCalculatePrice2DaysMotorcycleWithoutRestriction() {
		vehicle = vehicleTestDataBuilder.withLicensePlate(LICENSE_PLATE_NOT_STARTING_WITH_A)
				.withVehicleType(VehicleTypeEnum.MOTORCYCLE).withCylinderCapacity(CYLINDER_CAPACITY_400).build();
		ticketTestDataBuilder = ticketTestDataBuilder.withEntryDate(ENTRY_DATE_2_DAYS)
				.withExitDate(EXIT_DATE_2_DAYS).withVehicle(vehicle);
		ticket = ticketTestDataBuilder.build();
		
		float price = parking.calculatePrice(ticket); 
		
		assertEquals(EXPECTED_PRICE_2_DAY_MOTORCYCLE, price, 0F);
	}
	
	@Test
	public void vehicleCheckOutCalculatePrice1Day3HoursCarWithoutRestriction() {
		vehicle = vehicleTestDataBuilder.withLicensePlate(LICENSE_PLATE_NOT_STARTING_WITH_A)
				.withVehicleType(VehicleTypeEnum.CAR).build();
		ticketTestDataBuilder = ticketTestDataBuilder.withEntryDate(ENTRY_DATE_1_DAY_3_HOURS)
				.withExitDate(EXIT_DATE_1_DAY_3_HOURS).withVehicle(vehicle);
		ticket = ticketTestDataBuilder.build();
		
		float price = parking.calculatePrice(ticket); 
		
		assertEquals(EXPECTED_PRICE_1_DAY_3_HOUR_CAR, price, 0F);
	}
	
	@Test
	public void vehicleCheckOutCalculatePrice1Day3HoursMotorcycleWithoutRestriction() {
		vehicle = vehicleTestDataBuilder.withLicensePlate(LICENSE_PLATE_NOT_STARTING_WITH_A)
				.withVehicleType(VehicleTypeEnum.MOTORCYCLE).withCylinderCapacity(CYLINDER_CAPACITY_400).build();
		ticketTestDataBuilder = ticketTestDataBuilder.withEntryDate(ENTRY_DATE_1_DAY_3_HOURS)
				.withExitDate(EXIT_DATE_1_DAY_3_HOURS).withVehicle(vehicle);
		ticket = ticketTestDataBuilder.build();
		
		float price = parking.calculatePrice(ticket); 
		
		assertEquals(EXPECTED_PRICE_1_DAY_3_HOUR_MOTORCYCLE, price, 0F);
	}
	
	@Test
	public void vehicleCheckOutCalculatePrice8HoursMotorcycleGreaterThan500CC() {
		vehicle = vehicleTestDataBuilder.withLicensePlate(LICENSE_PLATE_NOT_STARTING_WITH_A)
				.withVehicleType(VehicleTypeEnum.MOTORCYCLE).withCylinderCapacity(CYLINDER_CAPACITY_650).build();
		ticketTestDataBuilder = ticketTestDataBuilder.withEntryDate(ENTRY_DATE_8_HOURS)
				.withExitDate(EXIT_DATE_8_HOURS).withVehicle(vehicle);
		ticket = ticketTestDataBuilder.build();
		
		float price = parking.calculatePrice(ticket); 
		
		assertEquals(EXPECTED_PRICE_8_HOURS_MOTORCYCLE_GREATER_500CC, price, 0F);
	}
	
	@Test
	public void vehicleCheckOutCalculatePrice2DaysMotorcycleGreaterThan500CC() {
		vehicle = vehicleTestDataBuilder.withLicensePlate(LICENSE_PLATE_NOT_STARTING_WITH_A)
				.withVehicleType(VehicleTypeEnum.MOTORCYCLE).withCylinderCapacity(CYLINDER_CAPACITY_650).build();
		ticketTestDataBuilder = ticketTestDataBuilder.withEntryDate(ENTRY_DATE_2_DAYS)
				.withExitDate(EXIT_DATE_2_DAYS).withVehicle(vehicle);
		ticket = ticketTestDataBuilder.build();
		
		float price = parking.calculatePrice(ticket); 
		
		assertEquals(EXPECTED_PRICE_2_DAY_MOTORCYCLE_GREATER_500CC, price, 0F);
	}
	
	@Test
	public void vehicleCheckOutCalculatePrice1Day3HoursMotorcycleGreaterThan500CC() {
		vehicle = vehicleTestDataBuilder.withLicensePlate(LICENSE_PLATE_NOT_STARTING_WITH_A)
				.withVehicleType(VehicleTypeEnum.MOTORCYCLE).withCylinderCapacity(CYLINDER_CAPACITY_650).build();
		ticketTestDataBuilder = ticketTestDataBuilder.withEntryDate(ENTRY_DATE_1_DAY_3_HOURS)
				.withExitDate(EXIT_DATE_1_DAY_3_HOURS).withVehicle(vehicle);
		ticket = ticketTestDataBuilder.build();
		
		float price = parking.calculatePrice(ticket); 
		
		assertEquals(EXPECTED_PRICE_1_DAY_3_HOUR_MOTORCYCLE_GREATER_500CC, price, 0F);
	}
}
