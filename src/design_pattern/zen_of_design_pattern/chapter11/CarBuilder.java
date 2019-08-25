package design_pattern.zen_of_design_pattern.chapter11;

import java.util.ArrayList;

public abstract class CarBuilder {
    public abstract void setSequence(ArrayList<String> sequence);

    public abstract CarModel getCarModel();
}
