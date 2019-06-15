package design_pattern.zen_of_design_pattern.chapter15;

public abstract class Command {
    protected RequirementGroup rg = new RequirementGroup();

    protected PageGroup pg = new PageGroup();

    protected CodeGroup cg = new CodeGroup();

    public abstract void execute();
}
