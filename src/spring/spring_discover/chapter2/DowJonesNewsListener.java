package spring.spring_discover.chapter2;

public class DowJonesNewsListener implements IFXNewsListener {
    @Override
    public Integer[] getAvailableNewsIds() {
        return new Integer[0];
    }

    @Override
    public FXNewsBean getNewsByPK(Integer newsId) {
        return null;
    }

    @Override
    public void postProcessIfNecessary(Integer newsId) {

    }
}
