package entity;

import java.util.*;

public class TaxiStation implements Iterable<Car> {
    private List<Car> list;

    public TaxiStation(List<Car> list) {
        this.list = list;
    }

    public List<Car> getCarWithSpeedAmountInRange(double from, double to) {
        List<Car> speedList = new ArrayList<>();
        for (Car car : list) {
            if (car.getSpeed() >= from && car.getSpeed() <= to) {
                speedList.add(car);
            }
        }
        return speedList;
    }

    public void sortByFuelСonsumption() {
        Collections.sort(list, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getFuelСonsumption() - o2.getFuelСonsumption();
            }
        });
    }

    public int getTaxiStationPrice() {
        int price = 0;
        for (Car car : list) {
            price +=car.getPrice();
        }
        return price;
    }

    @Override
    public Iterator<Car> iterator() {
        return list.iterator();
    }
}
