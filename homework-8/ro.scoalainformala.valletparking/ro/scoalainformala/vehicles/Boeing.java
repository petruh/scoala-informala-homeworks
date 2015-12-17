package ro.scoalainformala.vehicles;

public abstract class Boeing extends Helicopter {

	@Override
	protected float getPollutionPerKm(int altitude, double km) {
		float pollution;
		pollution = (altitude/200.0f)*(float)km;
		return pollution;
	}

}
