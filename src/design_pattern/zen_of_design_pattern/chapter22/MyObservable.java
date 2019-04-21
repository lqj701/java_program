package design_pattern.zen_of_design_pattern.chapter22;

public interface MyObservable {
    public void addObserver(MyObserver observer);

    public void deleteObserver(MyObserver observer);

    public void notifyObservers(String context);
}
