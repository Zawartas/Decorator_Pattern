package sample;

public class CarDecoratedWithBluRayPlayer extends CarDecorator {

    CarDecoratedWithBluRayPlayer(Car car) {
        super(car);
    }

    @Override
    public String info() {
        return car.info() + " BlueRay Player";
    }

    @Override
    public double price() {
        return car.price() + 1_500;
    }
}
