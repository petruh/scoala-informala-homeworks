package ro.scoalainformala.parking;

import java.util.ArrayList;
import java.util.HashMap;

import ro.scoalainformala.vehicles.Vehicle;

/**
 * This class models a valet parking. Generics are used so a car park can be
 * created for any type that implements <em>Vehicle</em>
 * 
 * @author petru
 */
public class ValletParking<T extends Vehicle> {

	private int floors;
	private int spotsPerFloor;
	private ArrayList<ParkingSpot<T>> parkingLot;
	private HashMap<Long, ParkingSpot<T>> keyCupboard;

	/**
	 * Default constructor that creates a parking with 10 <em>floors</em> and
	 * 100 <em>spots</em>
	 */
	public ValletParking() {
		this(10, 100);
	}

	/**
	 * @param floors
	 *            The number of floors of the parking.
	 * @param spots
	 *            The number of spots on each floor of the parking.
	 */
	public ValletParking(int floors, int spots) {
		this.floors = floors;
		this.spotsPerFloor = spots;
		parkingLot = new ArrayList<>(floors * spots);
		keyCupboard = new HashMap<>();
		populateParking();
	}

	/**
	 * Creates ParkingSpot objects corresponding to the number of floors and
	 * spots per floors. These objects are added to an internal ArrayList.
	 */
	private void populateParking() {
		for (int i = 0; i < (floors * spotsPerFloor); i++) {
			ParkingSpot<T> spot = new ParkingSpot<T>(i / spotsPerFloor, i % spotsPerFloor);
			parkingLot.add(spot);
		}
	}

	/**
	 * Iterates through all the parking lots until it finds one that is not
	 * occupied.
	 * 
	 * @return The first unoccupied <em>ParkingSpot<T></em> it finds in the
	 *         parking lot. This method throws an <em>IllegalStateException</em>
	 *         in case there are no available parking spots.
	 */
	private ParkingSpot<T> getFreeSpot() {
		ParkingSpot<T> spot = null;
		for (ParkingSpot<T> sc : parkingLot) {
			if (!sc.isOccupied()) {
				spot = sc;
				break;
			}
		}
		if (spot == null) {
			throw new IllegalStateException("The parking lot is full!");
		}
		return spot;
	}

	/**
	 * Parks a vehicle on an available spot in the parking. The vehicle
	 * <em>drive</em> method to simulate driving the vehicle from reception to
	 * the parking spot.
	 * 
	 * @param vehicle
	 *            The <em>Vehicle</em> to be parked.
	 * @return An <em>ParkingTicket</em> that can be used to retrieve the parked
	 *         vehicle from the parking.
	 */
	public ParkingTicket parkVehicle(T vehicle) {
		ParkingTicket ticket = new ParkingTicket(vehicle);
		ParkingSpot<T> spot = getFreeSpot();
		float distance = spot.getDistance();
		vehicle.start();
		vehicle.drive(distance);
		vehicle.stop();
		spot.parkVehicle(vehicle);
		keyCupboard.put(ticket.getUniqueTicket(), spot);
		return ticket;
	}

	/**
	 * Retrieves a vehicle from the parking spot.
	 * 
	 * @param ticket
	 *            The <em>ticket</em> used to find the <em>Vehicle</em> in the
	 *            parking.
	 * @return The <em>Vehicle</em> that was parked.
	 */
	public T retrieveVehicle(ParkingTicket ticket) {
		ParkingSpot<T> spot;
		T vehicle;
		spot = keyCupboard.get(ticket.getUniqueTicket());
		float distance = spot.getDistance();
		vehicle = spot.unparkVehicle();
		vehicle.start();
		vehicle.drive(distance);
		vehicle.stop();
		return vehicle;
	}
}
