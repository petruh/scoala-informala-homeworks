package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ro.scoalainformala.parking.ParkingSpot;
import ro.scoalainformala.vehicles.Car;
import ro.scoalainformala.vehicles.Logan;

//TODO CODE REVIEW: Tests should be located in its own test source directory. Please look at the Java testing guides
public class ParkingSpotTest {
	private ParkingSpot<Car> spot;
	private Car car;

	@Before
	public void setup() {
		spot = new ParkingSpot<Car>(1, 1);
		car = new Logan(27, "gshreh45wyhw4h54");
	}

	@Test
	public void checkParkVehicle() {
		spot.parkVehicle(car);
		Assert.assertEquals(true, spot.isOccupied());
	}

	@Test(expected = IllegalStateException.class)
	public void checkParkVehicle_with_occupied_spot() {
		spot.parkVehicle(car);
		spot.parkVehicle(car);
	}

	@Test
	public void checkUnparkVehicle() {
		spot.parkVehicle(car);
		spot.unparkVehicle();
		Assert.assertEquals(false, spot.isOccupied());
	}

	@Test(expected = IllegalStateException.class)
	public void checkUnparkVehicle_with_free_spot() {
		spot.unparkVehicle();
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkParkingSpot_with_negative_arguments() {
		spot = new ParkingSpot<>(-1, -1);
	}

}
