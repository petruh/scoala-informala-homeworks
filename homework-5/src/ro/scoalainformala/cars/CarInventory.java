package ro.scoalainformala.cars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * <P>This class models a car inventory. 
 * <P>The Car objects are held inside a HashMap. 
 * 
 * @author Petru
 *
 */
public class CarInventory {
	private HashMap<String, Car> map = new HashMap<String,Car>();
	
	/**
	 * Adds a Car to the internal HashMap used for storage.
	 * @param car the Car object to be added
	 */
	public void addCar(Car car) {
		map.put(car.getChassisNumber(), car);
	}
	
	/**
	 * Retrieves a car from the internal HashMap based on its chassis number.
	 * 
	 * @param chassisNumber the key based on which the Car object is retrieved from the internal HashMap.
	 * @return the car object inside the internal HashMap that has the provided <tt>chassis number</tt>. 
	 */
	public Car findCar(String chassisNumber){
		return map.get(chassisNumber);
	}
	
	/**
	 * Removes a car from the internal HashMap based on its chassis number.
	 * 
	 * @param chassisNumber the key based on which the Car object is removed from the internal HashMap.
	 */
	public void removeCar(String chassisNumber) {
		map.remove(chassisNumber);
	}
	
	/**
	 * This method returns a list with the most fuel efficient cars in the inventory.
	 * <p>The Car objects from the internal HashMap are transfered to an ArrayList and then sorted based on their fuel consumption.
	 * <p>The first Car in the sorted ArrayList is held as a reference for the efficiency. The list is then iterated through and all the Cars with an efficiency that is different from the reference are removed.
	 * 
	 * @return an <tt>ArrayList<Car>()</tt> with the most fuel efficient cars.
	 */
	public List<Car> getMostFuelEfficientCars(){
		List<Car> carList = new ArrayList<Car>();
		carList.addAll(map.values());			
		Collections.sort(carList, new Comparator<Car>(){
			@Override
			public int compare(Car c1, Car c2) {
				Float ef1 = c1.getFuelConsumption(5, 1);
				Float ef2 = c2.getFuelConsumption(5, 1);
				return ef1.compareTo(ef2);
			}
			
		});
		float bestFuelConsumption = carList.get(0).getFuelConsumption(5, 1);
		for (int i = 1; i < carList.size(); i++){
			if (carList.get(i).getFuelConsumption(5, 1) != bestFuelConsumption) {
				carList.remove(i);
				i--;
			}
		}
		return carList;
	}

}
