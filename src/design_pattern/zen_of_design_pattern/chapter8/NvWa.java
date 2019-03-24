package design_pattern.zen_of_design_pattern.chapter8;

public class NvWa {
    public static void main(String[] args) {
        AbstractHumanFactory YinYangLu = new HumanFactory();

        System.out.println("--造出的第一批人是白色人种---");
        Human whiteman = YinYangLu.createHuman(WhiteHuman.class);
        whiteman.getColor();
        whiteman.talk();
    }
}
