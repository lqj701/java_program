package design_pattern.zen_of_design_pattern.chapter22;

import java.util.Observable;
import java.util.Observer;

public class Lisi implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("李斯：观察到韩非子活动，开始向老板汇报了...");
        reportToQinShiHuang(arg.toString());
        System.out.println("李斯：汇报完毕...\n");
    }

    private void reportToQinShiHuang(String reportContext) {
        System.out.println("李斯：报告，秦老板！韩非子有活动了--->" + reportContext);
    }

}
