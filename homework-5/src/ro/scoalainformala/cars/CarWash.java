package ro.scoalainformala.cars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

public class CarWash {
	private LinkedList<Car> washQueue;
	private LinkedHashSet<Car> todaysClients;
	private ArrayList<Car> postponedClients;

	public void openShop() {
		washQueue = new LinkedList<Car> ();
		todaysClients = new LinkedHashSet<Car>();
	}
	
	public void closeShop() {
		postponedClients = new ArrayList<Car>();
		postponedClients.addAll(washQueue);
		washQueue.removeAll(washQueue);
	}
	
	public void standInLine(Car c) {
		washQueue.add(c);
	}
	
	public void washCar() {
		todaysClients.add(washQueue.removeFirst());
	}
	
	public void washCar(Car c) {
		if (washQueue.remove(c)) {
			todaysClients.add(c);
		}
	}
	
	public List<Car> getTodaysClients() {
		Car[] cars = new Car[todaysClients.size()];
		cars = todaysClients.toArray(cars);
		ArrayList<Car> todaysClients = new ArrayList<Car>(Arrays.asList(cars));
		return todaysClients;
	}
	
	public List<Car> getPostponedClients() {
		return postponedClients;
	}
}
