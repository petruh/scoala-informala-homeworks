package ro.scoalainformala.vehicles;

public class SuperCobra extends Bell {

	private static final int SUPERCOBRA_FUEL_TANK_SIZE = 1561;
	private static final int SUPERCOBRA_CEILING = 6096;
	
	public SuperCobra(float availableFuel, String chassisNumber) {
		this.fuelTank = SUPERCOBRA_FUEL_TANK_SIZE;
		this.ceiling = SUPERCOBRA_CEILING;
		this.chassisNumber = chassisNumber;
		this.availableFuel = availableFuel;
		this.fuelType = Fuels.JET_A;
	}

	@Override
	protected float getFuelConsumption(int altitude, double km) {
		return (float) ((km * 115.0f) / altitude);
	}
	
}
