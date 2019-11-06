package design_pattern.zen_of_design_pattern.chapter3;

// DIP（依赖倒置原则）
public class Client {
    public static void main(String[] args) {
        Driver driver = new Driver();

        Benz benz = new Benz();
        driver.drive(benz);

        BMW bmw = new BMW();
        driver.drive(bmw);
    }
}
