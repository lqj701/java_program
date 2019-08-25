package design_pattern.zen_of_design_pattern.chapter13;

import java.util.ArrayList;

public class Thing implements Cloneable {
    private ArrayList<String> arrayList = new ArrayList<>();

    @Override
    public Thing clone() {
        Thing thing = null;
        try {
            thing = (Thing) super.clone();
            thing.arrayList = (ArrayList<String>) this.arrayList.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return thing;
    }

    public void setValue(String value) {
        this.arrayList.add(value);
    }

    public ArrayList<String> getValue() {
        return this.arrayList;
    }
}
