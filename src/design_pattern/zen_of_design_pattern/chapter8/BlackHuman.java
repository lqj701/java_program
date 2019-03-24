package design_pattern.zen_of_design_pattern.chapter8;

public class BlackHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("黑色人种");
    }

    @Override
    public void talk() {
        System.out.println("黑人说话");
    }
}
