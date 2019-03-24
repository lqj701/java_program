package design_pattern.zen_of_design_pattern.chapter8;

public abstract class AbstractHumanFactory {
    public abstract <T extends Human> T createHuman(Class<T> c);
}
