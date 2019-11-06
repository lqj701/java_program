package dynamic_technology.program_logic.chapter23.jdk_proxy;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SimpleJDKDynamicProxyDemo {

    static interface IService {
        public void sayHello();
    }

    static class RealService implements IService {

        @Override
        public void sayHello() {
            System.out.println("hello");
        }
    }


    static class SimpleInvocationHandler implements InvocationHandler {
        private Object realObj;

        public SimpleInvocationHandler(Object realObj) {
            this.realObj = realObj;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("entering " + method.getName());
            Object result = method.invoke(realObj, args);
            System.out.println("leaving " + method.getName());
            return result;

        }
    }

    public static void main(String[] args) throws IOException {
        IService realService = new RealService();
        IService proxyService = (IService) Proxy.newProxyInstance(IService.class.getClassLoader(),
                new Class<?>[]{IService.class}, new SimpleInvocationHandler(realService));
        // File file = new File("ProxyService.class");
        // if (!file.exists()) {
        // file.createNewFile();
        // }
        // byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", IService.class.getInterfaces());
        // FileOutputStream fos = new FileOutputStream(file, true);
        // int index;
        // byte[] bytes = new byte[1024];
        // fos.write(classFile);
        // fos.flush();
        proxyService.sayHello();
    }
}
