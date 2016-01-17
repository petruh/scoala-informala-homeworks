package ro.scoalainformala.cars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * <P>This class models a car wash. 
 * <P>The Car objects are held inside a LinkedList that models the wash queue.
 * <P>The class also keeps track of the clients that use the car wash.
 * 
 * @author Petru
 *
 */
public class CarWash {
	private LinkedList<Car> washQueue;
	private LinkedHashSet<Car> todaysClients;
	private ArrayList<Car> postponedClients;

	/**
	 *<em>Opens</em> the Car Wash.
	 *New <i>Collections<i> are created for the internal fields that hold today's clients and the wash queue. 
	 * 
	 */
	public void openShop() {
		washQueue = new LinkedList<Car> ();
		todaysClients = new LinkedHashSet<Car>();
	}
	
	/**
	 * <em>Closes</em> the Car Wash.
	 * When the shop is closed all the clients that were waiting in the wash queue are transfered to the <em>postponed clients</em> ArrayList.
	 * The washQueue is then emptied.
	 */
	public void closeShop() {
		postponedClients = new ArrayList<Car>();
		postponedClients.addAll(washQueue);
		washQueue.removeAll(washQueue);
	}
	
	/**
	 * Adds a Car to the wash queue.
	 * @param c The Car object to be added to the wash queue.
	 */
	public void standInLine(Car c) {
		washQueue.add(c);
	}
	
	/**
	 * Removes the first Car from the wash queue and adds it to the HashSet that holds today's clients.
	 */
	public void washCar() {
		todaysClients.add(washQueue.removeFirst());
	}
	
	/**
	 * Removes the car provided as a parameter from the wash queue and adds it to the HashSet that holds today's clients.
	 * @param c the car to be washed
	 */
	public void washCar(Car c) {
		if (washQueue.remove(c)) {
			todaysClients.add(c);
		}
	}
	
	/**
	 * Returns an <em>ArrayList</em> with all the clients that got their car washed before the shop closed.
	 * @return A new <em>ArrayList</em> that is a copy of the internal class field <em>todaysClients</em>
	 */
	public List<Car> getTodaysClients() {
		Car[] cars = new Car[todaysClients.size()];
		cars = todaysClients.toArray(cars);
		ArrayList<Car> todaysClients = new ArrayList<Car>(Arrays.asList(cars));
		return todaysClients;
	}
	
	/**
	 * Returns an <em>ArrayList</em> with all the clients that were in the wash queue but didn't get their car washed before the shop closed.
	 * @return An <em>ArrayList</em> with the postponed clients.
	 */
	public List<Car> getPostponedClients() {
		return postponedClients;
	}
}
