package ro.scoalainformala.cars;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class CarInventory {
	private HashMap<String, Car> map = new HashMap<String,Car>();
	
	public void addCar(Car car) {
		map.put(car.getChassisNumber(), car);
	}
	
	public Car findCar(String chassisNumber){
		return map.get(chassisNumber);
	}
	
	public void removeCar(String chassisNumber) {
		map.remove(chassisNumber);
	}
	
	public List<Car> getMostFuelEfficientCars(){
		List<Car> carList = new ArrayList<Car>();
		carList.addAll(map.values());			
		carList.sort(new Comparator<Car>(){
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
