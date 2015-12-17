package ro.scoalainformala.vehicles;

public class Apache extends Bell {

	private static final int APACHE_FUEL_TANK_SIZE = 2231;
	private static final int APACHE_CEILING = 5521;
	
	public Apache(float availableFuel, String chassisNumber) {
		this.fuelTank = APACHE_FUEL_TANK_SIZE;
		this.ceiling = APACHE_CEILING;
		this.chassisNumber = chassisNumber;
		this.availableFuel = availableFuel;
		this.fuelType = Fuels.JET_A;
	}

	@Override
	protected float getFuelConsumption(int altitude, double km) {
		return (float) ((km * 100.0f) / altitude);
	}

}
