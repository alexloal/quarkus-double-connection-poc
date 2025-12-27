package org.alexloal.repositories;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.alexloal.model.Truck;

@ApplicationScoped
public class TruckRepository implements PanacheMongoRepository<Truck> {
}
