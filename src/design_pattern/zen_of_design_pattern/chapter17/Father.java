package design_pattern.zen_of_design_pattern.chapter17;

/**
 * decorator design pattern
 */
public class Father {
    public static void main(String[] args) {
        SchoolReport sr;
        sr = new FouthGradeSchoolReport();
        sr = new HignScoreDecorator(sr);
        sr = new SortDecorator(sr);

        sr.report();
        sr.sign("老三");
    }
}
