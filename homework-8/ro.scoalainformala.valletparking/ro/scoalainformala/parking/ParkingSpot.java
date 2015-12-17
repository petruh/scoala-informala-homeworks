package ro.scoalainformala.parking;

import ro.scoalainformala.vehicles.Vehicle;

/**
 * This class models a parking spot.
 * 
 * @author Petru
 * @param <T>
 *            Any class that implements the <em>Vehicle</em> interface.
 */
public class ParkingSpot<T extends Vehicle> {
	private int floor;
	private int number;
	private boolean occupied;
	private T vehicle;

	/**
	 * @param floor
	 *            the floor on which the parking spot is situated. Can't be
	 *            negative.
	 * @param number
	 *            the number on the floor where the parking spot is situated.
	 *            Can't be negative.
	 */
	public ParkingSpot(int floor, int number) {
		if (floor >= 0 && number >= 0) {
			this.floor = floor;
			this.number = number;
			occupied = false;
		} else {
			throw new IllegalArgumentException("The parking spot's floor and number can't be negative.");
		}
	}

	/**
	 * Parks a vehicle on the parking spot if the spot is free.
	 * 
	 * @param vehicle
	 *            The <em>Vehicle</em> to be parked.
	 */
	public void parkVehicle(T vehicle) {
		if (!occupied) {
			this.vehicle = vehicle;
			occupied = true;
		} else {
			throw new IllegalStateException("This spot is already occupied");
		}
	}

	/**
	 * Frees the parking spot.
	 * 
	 * @return The vehicle that was parked on the spot.
	 */
	public T unparkVehicle() {
		T vehicle = this.vehicle;
		this.vehicle = null;
		if (occupied) {
			occupied = false;
			return vehicle;
		} else {
			throw new IllegalStateException("There is no car parked on this spot");
		}
	}

	/**
	 * Calculates an imaginary distance to the parking spot based on its
	 * position (floor, number) in the parking.
	 * 
	 * @return The distance to the parking spot.
	 */
	public float getDistance() {
		float distance;
		distance = floor * 0.05f + (number + 1) * 0.005f;
		return distance;
	}

	/**
	 * @return True if the spot is occupied, false if its free.
	 */
	public boolean isOccupied() {
		return occupied;
	}

}
