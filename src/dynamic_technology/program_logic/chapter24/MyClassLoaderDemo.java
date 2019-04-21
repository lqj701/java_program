package dynamic_technology.program_logic.chapter24;

import sun.misc.Launcher;

public class MyClassLoaderDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        MyClassLoader cl1 = new MyClassLoader();
        String className = "dynamic_technology.program_logic.chapter24.HelloService";
        Class<?> class1 = cl1.findClass(className);

        Class.forName("dynamic_technology.program_logic.chapter24.HelloService");

        System.out.println(cl1.getParent());
        MyClassLoader cl2 = new MyClassLoader();

        ClassLoader cl3 = new Launcher().getClassLoader().getParent();
        System.out.println(cl3);
        Class<?> class2 = cl2.findClass(className);

        if (class1 != class2) {
            System.out.println("different classes");
        }
    }
}
