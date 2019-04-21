package design_pattern.zen_of_design_pattern.chapter23;

public class Client {
    public static void main(String[] args) {
        ModernPostOffice hellRoadPostOffice = new ModernPostOffice();

        String address = "Happy Road No.666";

        String context = "Hello,It's me";

        hellRoadPostOffice.sendLetter(context, address);
    }
}
