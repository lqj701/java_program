package design_pattern.zen_of_design_pattern.chapter8;

public abstract class Creator {
    public abstract <T extends Product> T createProduct(Class<T> c);
}
