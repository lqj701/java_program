package dynamic_technology.program_logic.chapter23;

import dynamic_technology.program_logic.chapter22.SimpleInject;

public class ServiceA {
    @SimpleInject
    ServiceB b;

    public void callB() {
        b.action();
    }

    public ServiceB getB() {
        return b;
    }
}
