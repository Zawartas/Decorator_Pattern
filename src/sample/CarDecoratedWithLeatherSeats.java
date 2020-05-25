package sample;

public class CarDecoratedWithLeatherSeats extends CarDecorator {

    CarDecoratedWithLeatherSeats(Car car) {
        super(car);
    }

    @Override
    public String info() {
        return car.info() + " Leather Seats";
    }

    @Override
    public double price() {
        return car.price() + 5_000;
    }
}
