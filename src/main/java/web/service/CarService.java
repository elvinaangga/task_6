package web.service;

import web.models.Car;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private final List<Car> cars;

    public CarService() {
        // Initialize with 5 cars
        cars = new ArrayList<>();
        cars.add(new Car("Toyota", "Camry", 2020));
        cars.add(new Car("Honda", "Accord", 2019));
        cars.add(new Car("Ford", "Mustang", 2021));
        cars.add(new Car("Tesla", "Model 3", 2022));
        cars.add(new Car("BMW", "X5", 2020));
    }

    /**
     * Returns the specified number of cars from the list
     * @param count Number of cars to return (null returns all cars)
     * @return List of cars
     */
    public List<Car> getCars(int count) {
        return count >= cars.size() ? cars : cars.subList(0, count);
    }
}

