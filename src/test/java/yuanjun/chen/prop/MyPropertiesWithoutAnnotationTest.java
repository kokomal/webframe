/**  
 * @Title: MyPropertiesWithoutAnnotationTest.java   
 * @Package: yuanjun.chen.prop   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: 陈元俊     
 * @date: 2018年10月8日 上午10:02:46   
 * @version V1.0 
 * @Copyright: 2018 All rights reserved. 
 */
package yuanjun.chen.prop;

import java.util.List;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.ApplicationContext;
import yuanjun.chen.WebframeApplication;

/**   
 * @ClassName: MyPropertiesWithoutAnnotationTest   
 * @Description: 自定义配置文件的测试，支持简单pojo配置，String的list配置以及复合pojo类型list的配置  
 * @author: 陈元俊 
 * @date: 2018年10月8日 上午10:02:46  
 */
public class MyPropertiesWithoutAnnotationTest {
    @Test
    public void testPropWithoutAnno() {
        ApplicationContext context = SpringApplication.run(WebframeApplication.class);
        Binder binder = Binder.get(context.getEnvironment());
        // 绑定简单配置
        MyPropertiesWithoutAnnotation foo = binder.bind("selfprops", Bindable.of(MyPropertiesWithoutAnnotation.class)).get();
        System.out.println(foo.getFoo()); // bar
        System.out.println(foo.getDatabasePlatform()); // sql
        
        // 绑定String类型的list
        List<String> post = binder.bind("selfprops.posts", Bindable.listOf(String.class)).get();
        System.out.println(post);
        
        // 绑定复合类型的list
        List<PostInfo> posts = binder.bind("selfprops.pojo.posts", Bindable.listOf(PostInfo.class)).get();
        System.out.println(posts);
    }
}
