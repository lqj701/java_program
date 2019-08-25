package design_pattern.zen_of_design_pattern.chapter15;

public class DeletePageCommand extends Command {

    @Override
    public void execute() {
        super.pg.find();

        super.rg.delete();

        super.rg.plan();
    }
}
