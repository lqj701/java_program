package design_pattern.zen_of_design_pattern.chapter2;

public class Soldier {
    private AbstractGun gun;

    public void setGun(AbstractGun gun) {
        this.gun = gun;
    }

    public void killEnemy() {
        System.out.println("士兵开始杀敌人.....");
        gun.shoot();
    }
}
