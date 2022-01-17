package entity;

import java.util.Objects;

public class Car {
    private String brand;
    private String model;
    private int price;
    private int fuelСonsumption;
    private int speed;
    private Roominess roominess;

    public Car(String brand, String model, int price, int fuelСonsumption, int speed, Roominess roominess) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.speed = speed;
        this.fuelСonsumption = fuelСonsumption;
        this.roominess = roominess;
    }

    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public int getPrice() {
        return price;
    }
    public int getFuelСonsumption() {
        return fuelСonsumption;
    }
    public int getSpeed() {
        return speed;
    }
    public Roominess getRoominess() {
        return roominess;
    }

    @Override
    public String toString() {
        return "Car { " + "brand: " + brand + ", model: " + model + ", price: " + price + ", fuelConsumption: " + fuelСonsumption +
                ", speed: " + speed + ", roominess: " + roominess + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Car car = (Car) obj;
        if (brand != car.brand) return false;
        if (model != car.model) return false;
        if (price != car.price) return false;
        if (fuelСonsumption != car.fuelСonsumption) return false;
        if (speed != car.speed) return false;
        if (roominess != car.roominess) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, price, fuelСonsumption, speed, roominess);
    }
}
