package ro.scoalainformala.vehicles;

public abstract class Ducati extends Motorcycle {

	@Override
	protected float getPollutionPerKm(int gear, double km) {
		float pollution;
		pollution = (gear/50.0f)/(float)km;
		return pollution;
	}

}
