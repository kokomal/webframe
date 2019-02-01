package yuanjun.chen.springseq;

import java.beans.PropertyDescriptor;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {
    public MyInstantiationAwareBeanPostProcessor() {
        System.out.println(Tag.CIRCLES + "这是InstantiationAwareBeanPostProcessorAdapter实现类构造器！！" + Tag.CIRCLES);
    }

    /** 接口方法、实例化Bean之前调用. */
    @Override
    public Object postProcessBeforeInstantiation(Class beanClass, String beanName) {
        System.out.println(
                Tag.CIRCLES + "InstantiationAwareBeanPostProcessor调用postProcessBeforeInstantiation方法" + Tag.CIRCLES);
        return null;
    }

    /** 接口方法、实例化Bean之后调用. */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println(
                Tag.CIRCLES + "InstantiationAwareBeanPostProcessor调用postProcessAfterInitialization方法" + Tag.CIRCLES);
        return bean;
    }

    /** 接口方法、设置某个属性时调用. */
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean,
            String beanName) {
        System.out.println(
                Tag.CIRCLES + "InstantiationAwareBeanPostProcessor调用postProcessPropertyValues方法" + Tag.CIRCLES);
        return pvs;
    }
}
