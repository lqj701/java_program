package dynamic_technology.program_logic.chapter23;

public class CGLibContainerDemo {
    public static void main(String[] args) {
        ServiceA a = CGLibContainer.getInstance(ServiceA.class);
        a.callB();
    }
}
