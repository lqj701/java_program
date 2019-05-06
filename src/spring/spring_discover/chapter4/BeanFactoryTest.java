package spring.spring_discover.chapter4;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.*;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import spring.spring_discover.chapter2.DowJonesNewsListener;
import spring.spring_discover.chapter2.DowJonesNewsPersister;
import spring.spring_discover.chapter2.FXNewsProvider;

public class BeanFactoryTest {
    public static void main(String[] args) throws BeansException {
        DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
        // 硬编码依赖绑定
        // BeanFactory container = bindViaCode(beanRegistry);

        // 读取配置文件
        BeanFactory container = buildViaXMLFile(beanRegistry);
        FXNewsProvider newsProvider = (FXNewsProvider) container.getBean("djNewsProvider");
        newsProvider.getAndPersistNews();
    }


    public static BeanFactory bindViaCode(BeanDefinitionRegistry registry) throws BeanDefinitionStoreException {
        AbstractBeanDefinition newsProvider = new RootBeanDefinition(FXNewsProvider.class);
        AbstractBeanDefinition newsListener = new RootBeanDefinition(DowJonesNewsListener.class);
        AbstractBeanDefinition newsPersister = new RootBeanDefinition(DowJonesNewsPersister.class);

        registry.registerBeanDefinition("djNewsProvider", newsProvider);
        registry.registerBeanDefinition("djListerner", newsListener);
        registry.registerBeanDefinition("djpersister", newsPersister);

        // 构造注入
        ConstructorArgumentValues argValues = new ConstructorArgumentValues();
        argValues.addIndexedArgumentValue(0, newsListener);
        argValues.addIndexedArgumentValue(1, newsPersister);
        newsProvider.setConstructorArgumentValues(argValues);

        // setter注入
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("newListener", newsListener));
        propertyValues.addPropertyValue(new PropertyValue("newPersistener", newsPersister));
        newsProvider.setPropertyValues(propertyValues);

        return (BeanFactory) registry;
    }

    public static BeanFactory buildViaXMLFile(BeanDefinitionRegistry registry) {
        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(registry);
        beanDefinitionReader.loadBeanDefinitions("/news-config.xml");
        return (BeanFactory) registry;
    }
}
