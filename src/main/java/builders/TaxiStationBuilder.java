package builders;

import java.util.List;

import entity.Car;
import entity.TaxiStation;
import utils.FileUtils;

public class TaxiStationBuilder {
    public static TaxiStation createTaxiStation() {
        FileUtils utils = new FileUtils();
        List<Car> list = utils.getCarListFromFile();
        TaxiStation taxiStation = new TaxiStation(list);
        return taxiStation;
    }
}
