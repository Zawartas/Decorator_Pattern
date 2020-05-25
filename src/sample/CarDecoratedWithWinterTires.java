package sample;

public class CarDecoratedWithWinterTires extends CarDecorator {

    CarDecoratedWithWinterTires(Car car) {
        super(car);
    }

    @Override
    public String info() {
        return car.info() + " Winter Tire";
    }

    @Override
    public double price() {
        return car.price() + 2_000;
    }
}
