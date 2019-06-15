package design_pattern.zen_of_design_pattern.chapter2;

public class AUG extends RifleGun {
    public void zoomOut() {
        System.out.println("通过望远镜查看敌人........");
    }

    @Override
    public void shoot() {
        System.out.println("AUG 射击.........");
    }
}
