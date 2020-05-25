package sample;

public class CarMercedesImpl implements Car {
    @Override
    public String info() {
        return "This is Mercedes";
    }

    @Override
    public double price() {
        return 750_000;
    }
}
