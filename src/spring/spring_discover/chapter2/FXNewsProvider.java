package spring.spring_discover.chapter2;

public class FXNewsProvider {
    private IFXNewsListener newsListener;
    private IFXNewsPersister newsPersister;

    public void getAndPersistNews() {
        Integer[] newsIds = newsListener.getAvailableNewsIds();

        if (newsIds.length == 0) {
            return;
        }

        for (Integer newsId : newsIds) {
            FXNewsBean newsBean = newsListener.getNewsByPK(newsId);
            newsPersister.persistNews(newsBean);
            newsListener.postProcessIfNecessary(newsId);
        }
    }
}
