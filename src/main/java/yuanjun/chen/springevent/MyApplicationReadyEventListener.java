package yuanjun.chen.springevent;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

/**   
 * @ClassName: MyApplicationReadyEventListener   
 * @Description: ApplicationReadyEvent：springboot 加载完成时候执行的事件  
 * @author: 陈元俊 
 * @date: 2018年10月8日 上午9:35:06  
 */
public class MyApplicationReadyEventListener implements ApplicationListener<ApplicationReadyEvent>{
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        applicationReadyEvent.getApplicationContext();
        System.out.println("<----4-----第四步Application完全加载成功--------->");
    }
}