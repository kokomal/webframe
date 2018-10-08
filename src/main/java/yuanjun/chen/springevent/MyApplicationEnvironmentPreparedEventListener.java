package yuanjun.chen.springevent;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import java.util.Iterator;

/**
 * @ClassName: MyApplicationEnvironmentPreparedEventListener
 * @Description: ApplicationEnvironmentPreparedEvent： spring boot
 *               对应Enviroment已经准备完毕，但此时上下文context还没有创建。 
 *               在该监听中获取到ConfigurableEnvironment后可以对配置信息做操作，
 *               例如：修改默认的配置信息，增加额外的配置信息等等。
 * @author: 陈元俊
 * @date: 2018年10月8日 上午9:29:05
 */
public class MyApplicationEnvironmentPreparedEventListener
        implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        System.out.println("<----2-----第二步准备环境变量--------->");
        ConfigurableEnvironment environment = event.getEnvironment();
        MutablePropertySources maps = environment.getPropertySources();
        if (maps != null) {
            Iterator<PropertySource<?>> its = maps.iterator();
            while (its.hasNext()) {
                PropertySource<?> ps = its.next();
                System.out.print(ps.getName() + "-----");
                System.out.print(ps.getSource() + "-----");
                System.out.println(ps.getClass());
            }
        }
    }

}
