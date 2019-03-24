package design_pattern.zen_of_design_pattern.chapter9;

public class NvWa {
    public static void main(String[] args) {
        HumanFactory femaleFactory = new FemaleFactory();

        Human femaleYellowHuman = femaleFactory.createYellowHuman();

        System.out.println("--生产一个黄人女性--");
        femaleYellowHuman.getColor();
        femaleYellowHuman.getSex();
        femaleYellowHuman.talk();

    }
}
