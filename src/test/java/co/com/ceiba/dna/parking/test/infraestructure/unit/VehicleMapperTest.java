package co.com.ceiba.dna.parking.test.infraestructure.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.dna.parking.domain.entity.Vehicle;
import co.com.ceiba.dna.parking.infraestructure.adapter.entity.VehicleEntity;
import co.com.ceiba.dna.parking.infraestructure.adapter.mapper.VehicleMapper;
import co.com.ceiba.dna.parking.test.domain.databuilder.VehicleTestDataBuilder;
import co.com.ceiba.dna.parking.test.infraestructure.databuilder.VehicleEntityTestDataBuilder;

public class VehicleMapperTest {
	
	private Vehicle vehicle;
	private VehicleEntity vehicleEntity;
	
	VehicleTestDataBuilder vehicleTestDataBuilder;
	VehicleEntityTestDataBuilder vehicleEntityTestDataBuilder;
	
	@Before
	public void setup() {
		vehicleTestDataBuilder = new VehicleTestDataBuilder();
		vehicleEntityTestDataBuilder = new VehicleEntityTestDataBuilder();
	}
	
	@Test
	public void domainVehicleToEntityVehicle() {
		vehicle = vehicleTestDataBuilder.build();
		vehicleEntity = VehicleMapper.toEntity(vehicle);
		assertEquals(vehicle.getLicensePlate(), vehicleEntity.getLicensePlate());
		assertEquals(vehicle.getCylinderCapacity(), vehicleEntity.getCylinderCapacity());
		assertEquals(vehicle.getVehicleType(), vehicleEntity.getVehicleType());
	}
	
	@Test
	public void entityVehicleToDomainVehicle() {
		vehicleEntity = vehicleEntityTestDataBuilder.build();
		vehicle = VehicleMapper.toDomain(vehicleEntity);
		assertEquals(vehicleEntity.getLicensePlate(), vehicle.getLicensePlate());
		assertEquals(vehicleEntity.getCylinderCapacity(), vehicle.getCylinderCapacity());
		assertEquals(vehicleEntity.getVehicleType(), vehicle.getVehicleType());
	}

}
