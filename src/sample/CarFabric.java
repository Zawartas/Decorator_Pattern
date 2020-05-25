package sample;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class CarFabric {
    private static interface CarMaker {
        Car make();
    }

    private static HashMap<String, CarMaker> carMakerHashMap = new HashMap<>() {
        {
            put("Mercedes", new CarMaker() {
                @Override
                public Car make() {
                    return new CarMercedesImpl();
                }
            });
            put("Skoda", ()->new CarSkodaImpl());
        }
    };

    public static Car makeCar(String type) {
        return carMakerHashMap.get(type).make();
    }

    public static String[] keys() {
        ArrayList<String> list = new ArrayList<>(carMakerHashMap.keySet());
        list.sort(Comparator.naturalOrder());
        return list.toArray(new String[list.size()]);
    }
}
