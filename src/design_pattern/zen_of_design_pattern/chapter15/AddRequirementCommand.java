package design_pattern.zen_of_design_pattern.chapter15;

public class AddRequirementCommand extends Command {

    @Override
    public void execute() {
        super.rg.find();
        super.rg.add();
        super.rg.plan();
    }
}
