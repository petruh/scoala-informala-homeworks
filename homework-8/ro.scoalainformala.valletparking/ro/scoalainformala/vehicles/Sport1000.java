package ro.scoalainformala.vehicles;

public class Sport1000 extends Ducati {
	
	private static final int SPORT1000_FUEL_TANK_SIZE = 30;
	private static final int SPORT1000_NO_GEARS = 3;
	
	public Sport1000(float availableFuel, String chassisNumber) {
		this.fuelTank = SPORT1000_FUEL_TANK_SIZE;
		this.numberOfGears = SPORT1000_NO_GEARS;
		this.chassisNumber = chassisNumber;
		this.availableFuel = availableFuel;
		this.fuelType = Fuels.PETROL;
	}
	

	@Override
	protected float getFuelConsumption(int gear, double km) {
		float fuelConsumption;
		
		switch (gear) {
		case 1: fuelConsumption = 5.74f;
				break;
		case 2: fuelConsumption = 4.45f;
				break;
		case 3: fuelConsumption = 3.21f;
				break;
		default: fuelConsumption = -1.0f;	
		}		
		fuelConsumption *= km/100;		
		return fuelConsumption;
	}

}
