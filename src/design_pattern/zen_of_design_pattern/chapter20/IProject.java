package design_pattern.zen_of_design_pattern.chapter20;

public interface IProject {
    public void add(String name, int num, int cost);

    public String getProjectInfo();

    public IProjectIterator iterator();
}
