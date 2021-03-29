package yuanjun.chen.springseq;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    public MyBeanFactoryPostProcessor() {
        System.out.println(Tag.STARS + "这是BeanFactoryPostProcessor实现类构造器！！" + Tag.STARS);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory arg0) {
        System.out.println(Tag.STARS + "BeanFactoryPostProcessor调用postProcessBeanFactory方法" + Tag.STARS);
        BeanDefinition bd = arg0.getBeanDefinition("person");
        bd.getPropertyValues().addPropertyValue("phone", "110"); // 篡改了bean的属性
    }
}
