package yuanjun.chen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import yuanjun.chen.springevent.MyApplicationEnvironmentPreparedEventListener;
import yuanjun.chen.springevent.MyApplicationFailedEventListener;
import yuanjun.chen.springevent.MyApplicationPreparedEventListener;
import yuanjun.chen.springevent.MyApplicationReadyEventListener;
import yuanjun.chen.springevent.MyApplicationStartedEventListener;
import yuanjun.chen.springevent.MyApplicationStartingEventListener;

/**   
 * @ClassName: WebframeApplication   
 * @Description: spring加载的事件监听
 * @SpecialThanksTo: senlinyang  
 * @author: 陈元俊 
 * @date: 2018年10月8日 上午9:25:36  
 */
@SpringBootApplication
public class WebframeApplication {
    public static void main(String[] args) {
        //SpringApplication.run(WebframeApplication.class, args);
        SpringApplication app =new SpringApplication(WebframeApplication.class);
        app.addListeners(new MyApplicationStartedEventListener()); // 启动完成
        app.addListeners(new MyApplicationStartingEventListener()); // 启动中
        app.addListeners(new MyApplicationEnvironmentPreparedEventListener()); // 环境变量准备好
        app.addListeners(new MyApplicationPreparedEventListener()); // app准备好
        app.addListeners(new MyApplicationFailedEventListener()); // 失败监听
        app.addListeners(new MyApplicationReadyEventListener()); // 加载完成
        app.run(args);
    }
}
