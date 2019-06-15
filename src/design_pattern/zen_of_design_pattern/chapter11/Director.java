package design_pattern.zen_of_design_pattern.chapter11;

import java.util.ArrayList;

public class Director {
    private ArrayList<String> sequece = new ArrayList<>();

    private BenzBuilder benzBuilder = new BenzBuilder();
    private BMWBuilder bmwBuilder = new BMWBuilder();

    public BenzModel getABenzModel() {
        this.sequece.clear();

        this.sequece.add("start");
        this.sequece.add("stop");

        this.benzBuilder.setSequence(this.sequece);

        return (BenzModel) this.benzBuilder.getCarModel();
    }

    public BenzModel getBBenzModel() {
        this.sequece.clear();
        this.sequece.add("engine boom");
        this.sequece.add("start");
        this.sequece.add("stop");

        this.benzBuilder.setSequence(this.sequece);
        return (BenzModel) this.benzBuilder.getCarModel();
    }

    public BMWModel getCBMWModel() {
        this.sequece.clear();
        this.sequece.add("alarm");
        this.sequece.add("start");
        this.sequece.add("stop");

        this.bmwBuilder.setSequence(this.sequece);
        return (BMWModel) this.bmwBuilder.getCarModel();
    }
}
