package design_pattern.zen_of_design_pattern.chapter15;

public class Client {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();

        // Command command = new AddRequirementCommand();
        Command command = new DeletePageCommand();
        invoker.setCommand(command);

        invoker.action();
    }
}
