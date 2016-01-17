package ro.scoalainformala.cars;

public class VWGolf extends VW {
	
	private static final int VWGOLF_FUEL_TANK_SIZE = 55;
	private static final int VWGOLF_NO_GEARS = 5;
	
	public VWGolf(float availableFuel, String chassisNumber) {
		this.fuelTank = VWGOLF_FUEL_TANK_SIZE;
		this.numberOfGears = VWGOLF_NO_GEARS;
		this.chassisNumber = chassisNumber;
		this.availableFuel = availableFuel;
		this.fuelType = Fuels.DIESEL;
	}

	@Override
	protected float getFuelConsumption(int gear, double km) {
		float fuelConsumption;
		
		switch (gear) {
		case 1: fuelConsumption = 8.21f;
				break;
		case 2: fuelConsumption = 7.18f;
				break;
		case 3: fuelConsumption = 6.1f;
				break;
		case 4: fuelConsumption = 5.21f;
				break;
		case 5: fuelConsumption = 3.97f;
				break;
		default: fuelConsumption = -1.0f;	
		}		
		fuelConsumption *= km/100;		
		return fuelConsumption;
	}
}
