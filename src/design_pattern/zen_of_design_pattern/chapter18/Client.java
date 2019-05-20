package design_pattern.zen_of_design_pattern.chapter18;

import java.util.Arrays;

/**
 * strategy pattern
 */
public class Client {
    public final static String ADD_SYMBOL = "+";
    public final static String SUB_SYMBOL = "-";

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        String symbol = args[1];

        int b = Integer.parseInt(args[2]);
        System.out.println("输入的参数为：" + Arrays.toString(args));

        if (symbol.equals(SUB_SYMBOL)) {
            System.out.println("运行结果为：" + a + symbol + b + "=" + Calculator.SUB.exec(a, b));
        } else if (symbol.equals(ADD_SYMBOL)) {
            System.out.println("运行结果为：" + a + symbol + b + "=" + Calculator.ADD.exec(a, b));
        }

    }
}
