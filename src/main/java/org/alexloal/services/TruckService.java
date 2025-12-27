package org.alexloal.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.alexloal.model.Truck;
import org.alexloal.repositories.TruckRepository;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class TruckService {

    @Inject
    TruckRepository truckRepository;

    public List<Truck> findAll() {
        return truckRepository.listAll();
    }

    public Optional<Truck> findById(String id) {
        return truckRepository.findByIdOptional(new ObjectId(id));
    }

    public Truck create(Truck truck) {
        truckRepository.persist(truck);
        return truck;
    }

    public Optional<Truck> update(String id, Truck truck) {
        return truckRepository.findByIdOptional(new ObjectId(id))
                .map(existingTruck -> {
                    existingTruck.setBrand(truck.getBrand());
                    existingTruck.setNumberOfWheels(truck.getNumberOfWheels());
                    truckRepository.persistOrUpdate(existingTruck);
                    return existingTruck;
                });
    }

    public boolean delete(String id) {
        return truckRepository.deleteById(new ObjectId(id));
    }

    public List<Truck> findByBrand(String brand) {
        return truckRepository.list("brand", brand);
    }

    public List<Truck> findByWheelsGreaterThan(int wheels) {
        return truckRepository.list("numberOfWheels > ?1", wheels);
    }
}
