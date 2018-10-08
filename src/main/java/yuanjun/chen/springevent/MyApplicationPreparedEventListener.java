package yuanjun.chen.springevent;

import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;

/**   
 * @ClassName: MyApplicationPreparedEventListener   
 * @Description: ApplicationPreparedEvent:spring boot上下文context创建完成，
 *               但此时spring中的bean是没有完全加载完成的。
 *               在获取完上下文后，可以将上下文传递出去做一些额外的操作。
 *               值得注意的是：在该监听器中是无法获取自定义bean并进行操作的。  
 * @author: 陈元俊 
 * @date: 2018年10月8日 上午9:26:57  
 */
public class MyApplicationPreparedEventListener implements ApplicationListener<ApplicationPreparedEvent>{

    @Override
    public void onApplicationEvent(ApplicationPreparedEvent event) {
        ConfigurableApplicationContext context = event.getApplicationContext();
        passContextInfo(context);
    }

    /**
     * 传递上下文
     * @param cac
     */
    private void passContextInfo(ApplicationContext cac) {
        //dosomething()
        System.out.println("<----3-----第三步App的上下文准备就绪(但Bean没有完全加载成功)--------->");
    }
}