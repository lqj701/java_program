package design_pattern.zen_of_design_pattern.chapter18;

public class Context {
    private Calculator cal = null;

    public Context(Calculator cal) {
        this.cal = cal;
    }

    public int exec(int a, int b, String symbol) {
        return cal.exec(a, b);
    }
}
