package concurrent.program_logic.chapter15;

public class RacerDemo {
    public static void main(String[] args) throws InterruptedException {
        int num = 10;
        FireFlag fireFlag = new FireFlag();

        Thread[] racers = new Thread[num];

        for (int i = 0; i < num; i++) {
            racers[i] = new Racer(fireFlag);
            racers[i].start();
        }

        Thread.sleep(1000);
        fireFlag.fire();
    }
}
