package yuanjun.chen.springevent;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

/**
 * @ClassName: MyApplicationStartingEventListener
 * @Description: ApplicationStartingEvent：springboot启动开始的时候执行的事件，
 *               在该事件中可以获取到SpringApplication对象，可做一些执行前的设置。
 * @author: 陈元俊
 * @date: 2018年10月8日 上午9:31:44
 */
public class MyApplicationStartedEventListener implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartingEvent) {
        SpringApplication application = applicationStartingEvent.getSpringApplication();
        application.setBannerMode(Banner.Mode.OFF);
        System.out.println("<----4-----第四步执行启动完成--------->");
    }

}
