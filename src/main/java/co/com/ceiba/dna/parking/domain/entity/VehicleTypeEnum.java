package co.com.ceiba.dna.parking.domain.entity;

public enum VehicleTypeEnum {
	
	CAR(1000F, 8000F, 20),
	MOTORCYCLE(500F, 4000F, 10);
	
	private final float hourPrice;
	private final float dayPrice;
	private final int maxQuantity;
	
	private VehicleTypeEnum(float hourPrice, float dayPrice, int maxQuantity) {
				this.hourPrice = hourPrice;
		this.dayPrice = dayPrice;
		this.maxQuantity = maxQuantity;
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
