package ro.scoalainformala.cars;

import java.util.List;

public class Test {

	public static void main(String[] args) {

		Car c1 = new Logan(27, "oiqe0934hkkadsn");
		Car c2 = new VWGolf(27, "oerree0934hkkadsn");
		Car c3 = new Sandero(27, "degteg4t43");
		Car c4 = new Sandero(27, "ggasdgsdgsdfgher435");
		Car c5 = new VWPassat(27, "oiqe0934hkkadsn");
		
		CarInventory ci = new CarInventory();

		ci.addCar(c1);
		ci.addCar(c2);
		ci.addCar(c3);
		ci.addCar(c4);
		ci.addCar(c5);

		Car car = ci.findCar("degteg4t43");
		System.out.println("The car you searched for:");
		System.out.println(car);

		ci.removeCar("oiqe0934hkkadsn");
		System.out.println("The car you removed:");
		System.out.println(ci.findCar("oiqe0934hkkadsn"));

		List<Car> cars = ci.getMostFuelEfficientCars();
		System.out.println("The most efficient cars:");
		System.out.println(cars);
		
		CarWash carWash = new CarWash();

		carWash.openShop();

		carWash.standInLine(c1); // car stands in line to get washed.

		carWash.standInLine(c2); // car2 stands in line to get washed.

		carWash.washCar(); // will wash the first car standing in line, which is car1

		carWash.standInLine(c3);

		carWash.washCar(); // will wash the next car standing in line, which is car2

		carWash.standInLine(c1);

		carWash.washCar();

		carWash.standInLine(c2);

		carWash.standInLine(c3);

		carWash.standInLine(c3);

		carWash.closeShop();

		List<Car> todaysClients = carWash.getTodaysClients(); // returns all clients that have visited the shop today. If car was washed twice, it should be returned once.

		List<Car> postponedClients = carWash.getPostponedClients(); // returns a list of clients who did not get to have their car washed. The shop closed while they were standing in line.
		
		System.out.println("Todays clients were:");
		System.out.println(todaysClients);
		System.out.println("Postponed clients:");
		System.out.println(postponedClients);
	}

}
