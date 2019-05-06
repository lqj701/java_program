package dynamic_technology.program_logic.chapter23;

import java.lang.reflect.Method;
import java.util.Arrays;

@Aspect({ServiceB.class})
public class ExceptionAspect {
    public static void exception(Object object, Method method, Object[] args, Throwable throwable) {
        System.out.println("exception when calling: " + method.getName() + "," + Arrays.toString(args));
    }
}
