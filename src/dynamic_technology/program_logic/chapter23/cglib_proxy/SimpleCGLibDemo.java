package dynamic_technology.program_logic.chapter23.cglib_proxy;


import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class SimpleCGLibDemo {
    static class RealService {
        public void sayHello() {
            System.out.println("hello");
        }
    }

    static class SimpleInterceptor implements MethodInterceptor {
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("entering " + method.getName());
            Object result = methodProxy.invokeSuper(o, objects);
            System.out.println("leaving " + method.getName());
            return result;
        }
    }

    private static <T> T getProxy(Class<T> cls) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(cls);
        enhancer.setCallback(new SimpleInterceptor());
        return (T) enhancer.create();
    }

    public static void main(String[] args) {
        RealService proxyService = getProxy(RealService.class);
        proxyService.sayHello();
    }
}
