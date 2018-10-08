package yuanjun.chen.springevent;

import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @ClassName: MyApplicationFailedEventListener
 * @Description: ApplicationFailedEvent:spring boot启动异常时执行事件，
 *               在异常发生时，最好是添加虚拟机对应的钩子进行资源的回收与释放，能友善的处理异常信息
 * @author: 陈元俊
 * @date: 2018年10月8日 上午9:32:59
 */
public class MyApplicationFailedEventListener implements ApplicationListener<ApplicationFailedEvent> {

    @Override
    public void onApplicationEvent(ApplicationFailedEvent applicationFailedEvent) {
        Throwable t = applicationFailedEvent.getException();
        System.out.println("---------FAILED---------" + t);
    }

}
