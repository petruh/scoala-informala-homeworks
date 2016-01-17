package ro.scoalainformala.cars;

public class Sandero extends Dacia {
	
	private static final int SANDERO_FUEL_TANK_SIZE = 55;
	private static final int SANDERO_NO_GEARS = 5;
	
	public Sandero(float availableFuel, String chassisNumber) {
		this.fuelTank = SANDERO_FUEL_TANK_SIZE;
		this.numberOfGears = SANDERO_NO_GEARS;
		this.chassisNumber = chassisNumber;
		this.availableFuel = availableFuel;
		this.fuelType = Fuels.PETROL;
	}

	@Override
	protected float getFuelConsumption(int gear, double km) {
		float fuelConsumption;
			
			switch (gear) {
				case 1: fuelConsumption = 8.23f;
						break;
				case 2: fuelConsumption = 7.59f;
						break;
				case 3: fuelConsumption = 6.21f;
						break;
				case 4: fuelConsumption = 5.02f;
						break;
				case 5: fuelConsumption = 4.3f;
						break;
				default: fuelConsumption = -1.0f;	
			}		
			fuelConsumption *= km/100;		
			return fuelConsumption;
		}

}
