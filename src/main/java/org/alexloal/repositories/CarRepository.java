package org.alexloal.repositories;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.alexloal.model.Car;

@ApplicationScoped
public class CarRepository implements PanacheMongoRepository<Car> {
}
