package spring.spring_discover.chapter2;

public interface IFXNewsListener {
    Integer[] getAvailableNewsIds();

    FXNewsBean getNewsByPK(Integer newsId);

    void postProcessIfNecessary(Integer newsId);
}
