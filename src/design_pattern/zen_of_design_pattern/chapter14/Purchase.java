package design_pattern.zen_of_design_pattern.chapter14;

public class Purchase extends AbstractColleague {
    public Purchase(AbstractMediator mediator) {
        super(mediator);
    }

    public void buyIBMcomputer(int number) {
        super.mediator.execute("purchase.buy", number);

    }

    public void refuseBuyIBM() {
        System.out.println("不再采购IBM电脑");
    }
}
