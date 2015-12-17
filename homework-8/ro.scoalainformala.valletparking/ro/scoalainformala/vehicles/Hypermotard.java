package ro.scoalainformala.vehicles;

public class Hypermotard extends Ducati {

	private static final int HYPERMOTARD_FUEL_TANK_SIZE = 35;
	private static final int HYPERMOTARD_NO_GEARS = 4;
	
	public Hypermotard(float availableFuel, String chassisNumber) {
		this.fuelTank = HYPERMOTARD_FUEL_TANK_SIZE;
		this.numberOfGears = HYPERMOTARD_NO_GEARS;
		this.chassisNumber = chassisNumber;
		this.availableFuel = availableFuel;
		this.fuelType = Fuels.PETROL;
	}
	

	@Override
	protected float getFuelConsumption(int gear, double km) {
		float fuelConsumption;
		
		switch (gear) {
		case 1: fuelConsumption = 6.24f;
				break;
		case 2: fuelConsumption = 5.32f;
				break;
		case 3: fuelConsumption = 4.21f;
				break;
		case 4: fuelConsumption = 2.11f;
		break;
		default: fuelConsumption = -1.0f;	
		}		
		fuelConsumption *= km/100;		
		return fuelConsumption;
	}

}
