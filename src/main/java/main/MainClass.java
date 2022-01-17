package main;

import builders.TaxiStationBuilder;
import entity.Car;
import entity.TaxiStation;

public class MainClass {
    public static void main(String[] args) {
        TaxiStation taxiStation = TaxiStationBuilder.createTaxiStation();
        System.out.println("Sort by fuel consumption: ");
        taxiStation.sortByFuelСonsumption();
        for (Car car : taxiStation) {
            System.out.println(car);
        }

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");

        for (Car car : taxiStation.getCarWithSpeedAmountInRange(200, 240)) {
            System.out.println(car + " Speed amount: " + car.getSpeed());
        }

        System.out.println("Taxi station price: " + taxiStation.getTaxiStationPrice());
    }
}
