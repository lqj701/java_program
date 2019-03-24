package design_pattern.zen_of_design_pattern.chapter8;

public class WhiteHuman implements Human {

    @Override
    public void getColor() {
        System.out.println("白色人种");
    }

    @Override
    public void talk() {
        System.out.println("白色人种说话");
    }
}
