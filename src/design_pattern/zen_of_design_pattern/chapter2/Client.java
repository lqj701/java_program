package design_pattern.zen_of_design_pattern.chapter2;

// ISP
public class Client {
    public static void main(String[] args) {
        Soldier soldier = new Soldier();
        soldier.setGun(new RifleGun());
        soldier.killEnemy();

        Snipper snipper = new Snipper();
        snipper.killEnemy(new AUG());
    }
}
