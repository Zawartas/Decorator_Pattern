package sample;

import java.util.ArrayList;
import java.util.HashMap;

public class CarDecoratorFabric {
    private static interface CarMaker {
        Car makeCar(Car car);
    }

    private static HashMap<String, CarMaker> carDecorationMakerHashMap =
            new HashMap<>() {
                {
                    put("Winter Tires", (car)->new CarDecoratedWithWinterTires(car));
                    put("Leather Seats", (car)->new CarDecoratedWithLeatherSeats(car));
                    put("BluRay Player", (car)->new CarDecoratedWithBluRayPlayer(car));
                }
            };

    public static Car makeCar(Car car, String decoration) {
        return carDecorationMakerHashMap.get(decoration).makeCar(car);
    }

    public static String[] keys() {
        ArrayList<String> ar = new ArrayList<>(carDecorationMakerHashMap.keySet());
        ar.sort((s, anotherString) -> s.compareTo(anotherString));
        return ar.toArray(new String[ar.size()]);
    }
}
