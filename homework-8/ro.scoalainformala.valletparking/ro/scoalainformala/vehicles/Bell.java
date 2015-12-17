package ro.scoalainformala.vehicles;

public abstract class Bell extends Helicopter {

	@Override
	protected float getPollutionPerKm(int altitude, double km) {
		float pollution;
		pollution = (altitude/100.0f)*(float)km;
		return pollution;
	}

}
