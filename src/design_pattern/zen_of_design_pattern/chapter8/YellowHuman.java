package design_pattern.zen_of_design_pattern.chapter8;

public class YellowHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("黄色人种");
    }

    @Override
    public void talk() {
        System.out.println("黄色人种说话");
    }
}
