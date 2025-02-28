package id.ac.ui.cs.advprog.eshop.repository;
import id.ac.ui.cs.advprog.eshop.model.Car;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepository extends GeneralProductRepository<Car> {
    static int id = 0;
    private List<Car> carData = new ArrayList<>();

    public Car updateCar(String id, Car updatedCar) {
        for (Car car : carData) {
            if (car.getProductId().equals(id)) {
                // Update the existing car with the new information
                car.setProductId(updatedCar.getProductId());
                car.setCarColor(updatedCar.getCarColor());
                car.setProductQuantity(updatedCar.getProductQuantity());
                return car;
            }
        }
        return null; // Handle the case where the car is not found
    }

}
