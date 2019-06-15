package design_pattern.zen_of_design_pattern.chapter11;

public class BenzModel extends CarModel {

    @Override
    protected void start() {
        System.out.println("奔驰车启动");
    }

    @Override
    protected void stop() {
        System.out.println("奔驰车停车");
    }

    @Override
    protected void alarm() {
        System.out.println("奔驰车鸣笛");
    }

    @Override
    protected void engineBoom() {
        System.out.println("奔驰车引擎启动");
    }
}
