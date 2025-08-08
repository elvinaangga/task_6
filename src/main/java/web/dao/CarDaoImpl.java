package web.dao;
//import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;
import web.models.Car;

@Repository
public class CarDaoImpl implements CarDao {
    private final List<Car> cars = List.of(
            new Car("Toyota", "Camry", 2022),
            new Car("Honda", "Accord", 2021),
            new Car("Ford", "Mustang", 2023),
            new Car("Tesla", "Model 3", 2023),
            new Car("BMW", "X5", 2022)
    );

    @Override
    public List<Car> getAllCars() {
        return cars;
    }
}
