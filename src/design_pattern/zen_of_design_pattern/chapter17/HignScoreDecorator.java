package design_pattern.zen_of_design_pattern.chapter17;

public class HignScoreDecorator extends Decorator {


    public HignScoreDecorator(SchoolReport sr) {
        super(sr);
    }

    private void reportHighScore() {
        System.out.println("这次考试语文最高是75，数学是78，自然是80");
    }

    @Override
    public void report() {
        this.reportHighScore();
        super.report();
    }
}
