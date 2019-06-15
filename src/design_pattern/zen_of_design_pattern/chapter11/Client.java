package design_pattern.zen_of_design_pattern.chapter11;

import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        // unused builder pattern
        BenzModel benz = new BenzModel();

        ArrayList<String> sequence = new ArrayList<>();
        sequence.add("engine boom");
        sequence.add("start");
        sequence.add("stop");

        benz.setSequence(sequence);
        benz.run();
        System.out.println("--------------------");
        // use builder pattern
        Director director = new Director();
        for (int i = 0; i < 10; i++) {
            director.getABenzModel().run();
            System.out.println(i + " --------------------");
        }
    }
}
