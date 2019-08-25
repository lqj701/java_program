package design_pattern.zen_of_design_pattern.chapter3;

public class Driver implements IDriver {
    @Override
    public void drive(ICar car) {
        car.run();
    }
}
