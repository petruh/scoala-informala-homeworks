package ro.scoalainformala.cars;

public class Logan extends Dacia {
	
	private static final int LOGAN_FUEL_TANK_SIZE = 50;
	private static final int LOGAN_NO_GEARS = 5;
	
	public Logan(float availableFuel, String chassisNumber) {
		this.fuelTank = LOGAN_FUEL_TANK_SIZE;
		this.numberOfGears = LOGAN_NO_GEARS;
		this.chassisNumber = chassisNumber;
		this.availableFuel = availableFuel;
		this.fuelType = Fuels.PETROL;
	}
	

	@Override
	protected float getFuelConsumption(int gear, double km) {
		float fuelConsumption;
		
		switch (gear) {
		case 1: fuelConsumption = 9.74f;
				break;
		case 2: fuelConsumption = 8.12f;
				break;
		case 3: fuelConsumption = 6.78f;
				break;
		case 4: fuelConsumption = 5.64f;
				break;
		case 5: fuelConsumption = 4.7f;
				break;
		default: fuelConsumption = -1.0f;	
		}		
		fuelConsumption *= km/100;		
		return fuelConsumption;
	}
}
