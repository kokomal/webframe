package yuanjun.chen.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {

    public static void main(String[] args) {

        @SuppressWarnings("resource")
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("stuBeans.xml");
        Person bean2 = (Person) ac.getBean("student2");
        bean2.say();
    }
}
