package ro.scoalainformala.vehicles;

public abstract class Motorcycle implements Vehicle {
	
	public enum Fuels {								
		PETROL, ELECTRIC 
	}
	
	protected String chassisNumber;
	protected float fuelTank;
	protected Fuels fuelType;
	protected int numberOfGears;
	protected int gear;
	protected float consumption; //total consumption.
	protected float pollution;   //total pollution.
	protected float availableFuel;
	protected float totalDistance;
	
	@Override
	public final void start() {
		if (gear == 0) {
			consumption = 0;
			pollution = 0;
			totalDistance = 0;
		}
		else {
			throw new IllegalStateException("Error: The bike is not in neutral.");
		}		
	}

	@Override
	public void stop() {
		gear = 0;
	}

	@Override
	public void drive(double km) {
		float crtConsumption;
		if (this.gear == 0) {
			this.gear = 1;
		}
		crtConsumption = getFuelConsumption(this.gear, km);
		consumption += crtConsumption;
		this.availableFuel -= crtConsumption;
		if (this.availableFuel > 0) {
			totalDistance += km;
			pollution += getPollutionPerKm(this.gear, km);
		}
		else {
			throw new IllegalStateException("The car is out of fuel.");
		}
	}
	
	@Override
	public float getCurrentAmountOfFuel() {
		return availableFuel;
	}

	public float getPollution() {
		float averagePollution;
		averagePollution = (100*pollution)/totalDistance;
		return averagePollution;
	}
	
	public String getChassisNumber() {
		return chassisNumber;
	}
	
	public void shiftGear(int gear) {
		if ((gear >= 0) && (gear <= numberOfGears)) {
			this.gear = gear;
		}
		else {
			System.out.println("Error: Invalid gear.");
			System.exit(0);
		}
	}
	
	public float getAverageFuelConsumption() {
		float averageFuelConsumption;
		averageFuelConsumption = (100*consumption)/totalDistance;
		return averageFuelConsumption;
	}
	
	
	protected abstract float getFuelConsumption(int gear, double km);
	
	protected abstract float getPollutionPerKm(int gear, double km);

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(availableFuel);
		result = prime * result + ((chassisNumber == null) ? 0 : chassisNumber.hashCode());
		result = prime * result + Float.floatToIntBits(consumption);
		result = prime * result + Float.floatToIntBits(fuelTank);
		result = prime * result + ((fuelType == null) ? 0 : fuelType.hashCode());
		result = prime * result + gear;
		result = prime * result + numberOfGears;
		result = prime * result + Float.floatToIntBits(pollution);
		result = prime * result + Float.floatToIntBits(totalDistance);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Motorcycle other = (Motorcycle) obj;
		if (Float.floatToIntBits(availableFuel) != Float.floatToIntBits(other.availableFuel))
			return false;
		if (chassisNumber == null) {
			if (other.chassisNumber != null)
				return false;
		} else if (!chassisNumber.equals(other.chassisNumber))
			return false;
		if (Float.floatToIntBits(consumption) != Float.floatToIntBits(other.consumption))
			return false;
		if (Float.floatToIntBits(fuelTank) != Float.floatToIntBits(other.fuelTank))
			return false;
		if (fuelType != other.fuelType)
			return false;
		if (gear != other.gear)
			return false;
		if (numberOfGears != other.numberOfGears)
			return false;
		if (Float.floatToIntBits(pollution) != Float.floatToIntBits(other.pollution))
			return false;
		if (Float.floatToIntBits(totalDistance) != Float.floatToIntBits(other.totalDistance))
			return false;
		return true;
	}

}
