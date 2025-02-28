package id.ac.ui.cs.advprog.eshop.service;
import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

@Service
public class CarServiceImpl implements GeneralProductService<Car> {
    @Autowired
    private CarRepository carRepository;

    @Override
    public Car create(Car car) {
        //TODO Auto-generated method stub
        carRepository.create(car);
        return car;
    }

    @Override
    public List<Car> findAll() {
        Iterator<Car> carIterator = carRepository.findAll();
        List<Car> allCar = new ArrayList<>();
        carIterator.forEachRemaining(allCar::add);
        return allCar;
    }

    @Override
    public Car findById(String id) {
        //TODO Auto-generated method stub
        Car car = carRepository.findById(id);
        return car;
    }

    @Override
    public void edit(String carId, Car car) {
        //TODO Auto-generated method stub
        carRepository.updateCar(carId, car);
    }

    @Override
    public void delete(String carId) {
        //TODO Auto-generated method stub
        carRepository.delete(carId);
    }
}