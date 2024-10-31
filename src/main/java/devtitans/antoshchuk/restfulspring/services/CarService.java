package devtitans.antoshchuk.restfulspring.services;

import devtitans.antoshchuk.restfulspring.models.Car;
import devtitans.antoshchuk.restfulspring.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private CarRepository carRepository;
    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void createCar(Car car) {
        carRepository.save(car);
    }
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
    public Car getCarById(int id) {
        return carRepository.findById(id).orElse(null);
    }
    public void deleteCarById(int id) {
        carRepository.deleteById(id);
    }
    public void updateCar(Car car, int id) {
        Car carForUpdate = carRepository.findById(id).orElse(null);
        carForUpdate.setBrand(car.getBrand());
        carForUpdate.setModel(car.getModel());
        carForUpdate.setPrice(car.getPrice());
        carRepository.save(carForUpdate);
    }
}
