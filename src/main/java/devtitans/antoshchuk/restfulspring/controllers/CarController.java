package devtitans.antoshchuk.restfulspring.controllers;

import devtitans.antoshchuk.restfulspring.DTOs.CarDTO;
import devtitans.antoshchuk.restfulspring.models.Car;
import devtitans.antoshchuk.restfulspring.services.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CarController {

    private final CarService carService;
    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/all_cars/")
    private List<CarDTO> allCars() {
        return carService.getAllCars().stream()
                .map(this::convertCarToCarDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/car/{id}")
    private CarDTO findCarById(@PathVariable("id") int id) {
        Car car = carService.getCarById(id);
        return convertCarToCarDTO(car);
    }

    @PostMapping("/add_car")
    public ResponseEntity<?> addCar(@RequestBody CarDTO carDTO) {
        Car car = convertCarDTOToCar(carDTO);
        carService.createCar(car);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete_car/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable("id") int id) {
        Car car = carService.getCarById(id);
        carService.deleteCarById(id);

        return ResponseEntity.ok().build();
    }

    @PatchMapping("/update_car/{id}")
    public ResponseEntity<?> updateCar(@PathVariable("id") int id, @RequestBody CarDTO carDTO) {
        Car updatedCar = convertCarDTOToCar(carDTO);
        carService.updateCar(updatedCar, id);
        return ResponseEntity.ok().build();
    }


    private CarDTO convertCarToCarDTO(Car car) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(car, CarDTO.class);
    }
    private Car convertCarDTOToCar(CarDTO carDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(carDTO, Car.class);
    }
}
