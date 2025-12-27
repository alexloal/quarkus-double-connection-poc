package org.alexloal.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.alexloal.model.Car;
import org.alexloal.repositories.CarRepository;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CarService {

    @Inject
    CarRepository carRepository;

    public List<Car> findAll() {
        return carRepository.listAll();
    }

    public Optional<Car> findById(String id) {
        return carRepository.findByIdOptional(new ObjectId(id));
    }

    public Car create(Car car) {
        carRepository.persist(car);
        return car;
    }

    public Optional<Car> update(String id, Car car) {
        return carRepository.findByIdOptional(new ObjectId(id))
                .map(existingCar -> {
                    existingCar.setName(car.getName());
                    existingCar.setColour(car.getColour());
                    carRepository.persistOrUpdate(existingCar);
                    return existingCar;
                });
    }

    public boolean delete(String id) {
        return carRepository.deleteById(new ObjectId(id));
    }

    public List<Car> findByColour(String colour) {
        return carRepository.list("colour", colour);
    }
}
