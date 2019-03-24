package design_pattern.zen_of_design_pattern.chapter10;

public abstract class HummerModel {

    protected abstract void start();

    protected abstract void stop();

    protected abstract void alarm();

    protected abstract void engineBoom();

    final public void run() {
        this.start();

        this.engineBoom();

        if (this.isAlarm()) {
            this.alarm();
        }
    }

    protected boolean isAlarm() {
        return true;
    }
}
