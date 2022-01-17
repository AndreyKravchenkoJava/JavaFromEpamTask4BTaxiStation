package builders;

import entity.Car;
import entity.Roominess;

public class CarVolkswagenBuilder implements CarBuilder {
    @Override
    public Car createCar() {
        return new Car("Volkswagen", "Transporter", 12000, 15, 200, Roominess.EIGHT);
    }
}
