package ro.scoalainformala.parking;

import ro.scoalainformala.vehicles.Vehicle;

/**
 * This class is used for generating tickets when a Vehicle is parked.
 * 
 * @author Petru
 *
 */
public class ParkingTicket {
	private long uniqueTicket;

	/**
	 * Generates an unique ticket based on the hashCode of the parked vehicle.
	 * 
	 * @param vehicle
	 *            The vehicle that is parked
	 */
	ParkingTicket(Vehicle vehicle) {
		uniqueTicket = vehicle.hashCode();
	}

	public long getUniqueTicket() {
		return uniqueTicket;
	}
}
