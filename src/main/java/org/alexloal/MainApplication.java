package org.alexloal;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import org.alexloal.model.Car;
import org.alexloal.model.Truck;
import org.alexloal.services.CarService;
import org.alexloal.services.TruckService;
import org.jboss.logging.Logger;

@QuarkusMain
public class MainApplication implements QuarkusApplication {

    private static final Logger LOG = Logger.getLogger(MainApplication.class);

    @Inject
    CarService carService;

    @Inject
    TruckService truckService;

    public static void main(String... args) {
        Quarkus.run(MainApplication.class, args);
    }

    @Override
    public int run(String... args) {
        LOG.info("Starting application...");

        // Create and save a car
        Car car = Car.builder()
                .name("Tesla Model 3")
                .colour("Red")
                .build();
        carService.create(car);
        LOG.infof("Created car: %s", car);

        // Create and save a truck
        Truck truck = Truck.builder()
                .brand("Volvo")
                .numberOfWheels(6)
                .build();
        truckService.create(truck);
        LOG.infof("Created truck: %s", truck);

        // List all cars
        LOG.info("All cars:");
        carService.findAll().forEach(c -> LOG.infof(" - %s", c));

        // List all trucks
        LOG.info("All trucks:");
        truckService.findAll().forEach(t -> LOG.infof(" - %s", t));

        LOG.info("Application finished successfully!");
        return 0;
    }
}
