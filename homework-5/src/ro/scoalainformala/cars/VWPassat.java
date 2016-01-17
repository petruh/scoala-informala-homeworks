package ro.scoalainformala.cars;

public class VWPassat extends VW {
	
	private static final int VWPASSAT_FUEL_TANK_SIZE = 55;
	private static final int VWPASSAT_NO_GEARS = 5;
	
	public VWPassat(float availableFuel, String chassisNumber) {
		this.fuelTank = VWPASSAT_FUEL_TANK_SIZE;
		this.numberOfGears = VWPASSAT_NO_GEARS;
		this.chassisNumber = chassisNumber;
		this.availableFuel = availableFuel;
		this.fuelType = Fuels.DIESEL;
	}

	@Override
	protected float getFuelConsumption(int gear, double km) {
		float fuelConsumption;
		
			switch (gear) {
				case 1: fuelConsumption = 9.43f;
						break;
				case 2: fuelConsumption = 8.21f;
						break;
				case 3: fuelConsumption = 6.56f;
						break;
				case 4: fuelConsumption = 5.91f;
						break;
				case 5: fuelConsumption = 4.97f;
						break;
				default: fuelConsumption = -1.0f;	
			}		
			fuelConsumption *= km/100;		
			return fuelConsumption;
		}
}
