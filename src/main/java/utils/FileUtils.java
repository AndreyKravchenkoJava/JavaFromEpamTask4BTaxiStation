package utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import builders.CarBuilder;
import builders.CarBuilderPool;
import org.apache.log4j.Logger;

import builders.Director;
import builders.CarBuilder;
import entity.Car;

public class FileUtils {
    private static final Logger log = Logger.getLogger("FileUtils.class");
    private static final String FILE_FuLL_PATH = "./res/Car.txt";

    public List<Car> getCarListFromFile() {
        List<Car> carList = new ArrayList<>();
        File file = new File(FILE_FuLL_PATH);

        try {
            List<String> fileRows = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
            Map<String, Integer> carSet = parseFileRows(fileRows);
            carList = createCertainObject(carSet);
        } catch (IOException e) {
            log.error(e);
        }
        return carList;
    }

    private Map<String, Integer> parseFileRows(List<String> fileRows) {
        Map<String, Integer> map = new HashMap<>();
        String[] splitedRow;
        for (int i = 0; i < fileRows.size(); i++) {
            splitedRow =fileRows.get(i).trim().split(",");
            if (splitedRow.length == 2) {
                try {
                    int count = Integer.parseInt(splitedRow[1]);
                    map.put(splitedRow[0], count);
                } catch (NumberFormatException e) {
                    log.error(e);
                }
            } else {
                if (!("".equals(splitedRow[0]))) {
                    log.warn("Invalid rows format: " + fileRows.get(i));
                }
            }
        }
        return map;
    }

    private List<Car> createCertainObject(Map<String, Integer> carSet) {
        List<Car> carList = new ArrayList<>();
        CarBuilderPool cbp = new CarBuilderPool();
        Director director = new Director();
        for (Map.Entry<String, Integer> element : carSet.entrySet()) {
            int count = 0;
            for (Class<? extends CarBuilder> clazz : cbp) {
                count++;
                if (clazz.getSimpleName().equals(element.getKey())) {
                    try {
                        director.setBuilder(clazz.newInstance());
                        for (int i = 0; i < element.getValue(); i++) {
                            carList.add(director.createCar());
                        }
                    } catch (InstantiationException | IllegalAccessException e) {
                        log.error(e);
                    }
                    count--;
                }
            }
            if (count == cbp.getPoolSize()) {
                log.warn("Such builder doesent exist: " + element.getKey());
            }
        }
        return carList;
    }
}
