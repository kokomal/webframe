package yuanjun.chen.springseq;

import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
    public MyBeanPostProcessor() {
        System.out.println(Tag.SQUARES + "这是BeanPostProcessor实现类构造器！！" + Tag.SQUARES);
    }

    @Override
    public Object postProcessAfterInitialization(Object arg0, String arg1) {
        System.out.println(Tag.SQUARES + "BeanPostProcessor接口方法postProcessAfterInitialization对属性进行更改！" + Tag.SQUARES);
        return arg0;
    }

    @Override
    public Object postProcessBeforeInitialization(Object arg0, String arg1) {
        System.out.println(Tag.SQUARES + "BeanPostProcessor接口方法postProcessBeforeInitialization对属性进行更改！" + Tag.SQUARES);
        return arg0;
    }
}
