package builders;

import entity.Car;
import entity.Roominess;

public class CarSkodaBuilder implements CarBuilder {
    @Override
    public Car createCar() {
        return new Car("Skoda", "Fabia", 9000, 12, 220, Roominess.SIX);
    }
}
