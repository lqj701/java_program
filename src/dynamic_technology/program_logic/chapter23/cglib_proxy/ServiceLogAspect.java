package dynamic_technology.program_logic.chapter23.cglib_proxy;

import java.lang.reflect.Method;
import java.util.Arrays;

import dynamic_technology.program_logic.chapter23.ServiceA;
import dynamic_technology.program_logic.chapter23.ServiceB;

// @Aspect注解定义切面类，value值定义目标对象（需要增强的对象）
@Aspect({ServiceA.class, ServiceB.class})
public class ServiceLogAspect {
    // 织入方法，Advice
    public static void before(Object object, Method method, Object[] args) {
        System.out.println("entering " + method.getDeclaringClass().getSimpleName() + "::" + method.getName()
                + ",args: " + Arrays.toString(args));
    }


    public static void after(Object object, Method method, Object[] args, Object result) {
        System.out.println("leaving " + method.getDeclaringClass().getSimpleName() + "::" + method.getName()
                + ", result：" + result);
    }
}
