package ro.scoalainformala.vehicles;

public abstract class VW extends Car {

	@Override
	protected float getPollutionPerKm(int gear, double km) {
		// This is most likely an emissions test so we'll just return 0 :)
		return 0;
	}

}
