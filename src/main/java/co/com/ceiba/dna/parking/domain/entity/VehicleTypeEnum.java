package co.com.ceiba.dna.parking.domain.entity;

public enum VehicleTypeEnum {
	
	CAR("Carro", 1000F, 8000F, 20),
	MOTORCYCLE("Moto", 500F, 4000F, 10);
	
	private final String name;
	private final float hourPrice;
	private final float dayPrice;
	private final int maxQuantity;
	
	private VehicleTypeEnum(String name, float hourPrice, float dayPrice, int maxQuantity) {
		this.name = name;
		this.hourPrice = hourPrice;
		this.dayPrice = dayPrice;
		this.maxQuantity = maxQuantity;
	}

	public String getName() {
		return name;
	}

	public float getHourPrice() {
		return hourPrice;
	}

	public float getDayPrice() {
		return dayPrice;
	}

	public int getMaxQuantity() {
		return maxQuantity;
	}
}
