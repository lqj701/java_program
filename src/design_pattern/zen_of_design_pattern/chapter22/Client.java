package design_pattern.zen_of_design_pattern.chapter22;

import java.util.Observer;

/**
 * observer pattern
 */
public class Client {
    public static void main(String[] args) {
        HanFeiZi hanFeiZi = new HanFeiZi();
        Observer lisi = new Lisi();
        hanFeiZi.addObserver(lisi);

        hanFeiZi.haveBreakfast();
    }
}
