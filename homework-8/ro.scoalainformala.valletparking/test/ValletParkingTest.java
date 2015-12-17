package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ro.scoalainformala.parking.*;
import ro.scoalainformala.vehicles.*;

public class ValletParkingTest {

	private ValletParking<Car> carPark;
	private Car car;

	@Before
	public void setup() {
		carPark = new ValletParking<>();
		car = new Logan(27, "gshreh45wyhw4h54");
	}

	@Test
	public void checkParkVehicle() {
		Car expected = car;
		ParkingTicket ticket = carPark.parkVehicle(car);
		Car actual = carPark.retrieveVehicle(ticket);
		Assert.assertSame(expected, actual);
	}

	@Test(expected = IllegalStateException.class)
	public void checkParkVehicle_with_full_parking() {
		ValletParking<Car> carPark = new ValletParking<Car>(1, 1);
		carPark.parkVehicle(car);
		carPark.parkVehicle(car);
	}

	@Test
	public void checkFuelAmmountAfterParking() {
		float initialFuel = car.getCurrentAmountOfFuel();
		carPark.parkVehicle(car);
		float actualFuel = car.getCurrentAmountOfFuel();
		Assert.assertTrue(initialFuel > actualFuel);
	}
	
	@Test
	public void checkFuelAmmountAfterRetrieving() {
		ParkingTicket ticket = carPark.parkVehicle(car);
		float initialFuel = car.getCurrentAmountOfFuel();
		carPark.retrieveVehicle(ticket);
		float actualFuel = car.getCurrentAmountOfFuel();
		Assert.assertTrue(initialFuel > actualFuel);
	}


}
