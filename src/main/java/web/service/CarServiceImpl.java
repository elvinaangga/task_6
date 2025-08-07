package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import web.dao.CarDao;
import web.models.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final CarDao carDao;

    @Autowired
    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public List<Car> getCars(Integer count) {
        List<Car> allCars = carDao.getAllCars();
        if (count == null || count >= allCars.size()) {
            return allCars;
        }
        return allCars.subList(0, count);
    }
}

