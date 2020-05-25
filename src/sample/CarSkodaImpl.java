package sample;

public class CarSkodaImpl implements Car {
    @Override
    public String info() {
        return "This is Skoda";
    }

    @Override
    public double price() {
        return 57_000;
    }
}
