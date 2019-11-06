package dynamic_technology.program_logic.chapter23.cglib_proxy;

import dynamic_technology.program_logic.chapter23.ServiceA;

public class CGLibContainerDemo {
    public static void main(String[] args) {
        ServiceA a = CGLibContainer.getInstance(ServiceA.class);
        a.callB();
    }
}
