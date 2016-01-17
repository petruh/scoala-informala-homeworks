package ro.scoalainformala.cars;

public abstract class Dacia extends Car {

	@Override
	protected float getPollutionPerKm(int gear, double km) {
		float pollution;
		pollution = (gear/100.0f)/(float)km;
		return pollution;
	}
}
