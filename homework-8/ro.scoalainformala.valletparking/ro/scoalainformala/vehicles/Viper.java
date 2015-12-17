package ro.scoalainformala.vehicles;

public class Viper extends Bell {

	private static final int VIPER_FUEL_TANK_SIZE = 1231;
	private static final int VIPER_CEILING = 6345;
	
	public Viper(float availableFuel, String chassisNumber) {
		this.fuelTank = VIPER_FUEL_TANK_SIZE;
		this.ceiling = VIPER_CEILING;
		this.chassisNumber = chassisNumber;
		this.availableFuel = availableFuel;
		this.fuelType = Fuels.KEROSENE;
	}

	@Override
	protected float getFuelConsumption(int altitude, double km) {
		return (float) ((km * 245.0f) / altitude);
	}

}
