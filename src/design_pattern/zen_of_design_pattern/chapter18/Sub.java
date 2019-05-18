package design_pattern.zen_of_design_pattern.chapter18;

public class Sub implements ICalculator {
    @Override
    public int exec(int a, int b) {
        return a - b;
    }
}
