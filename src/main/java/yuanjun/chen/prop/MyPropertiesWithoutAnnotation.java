/**  
 * @Title: MyPropertiesWithoutAnnotation.java   
 * @Package: yuanjun.chen.prop   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: 陈元俊     
 * @date: 2018年10月8日 上午9:58:47   
 * @version V1.0 
 * @Copyright: 2018 All rights reserved. 
 */
package yuanjun.chen.prop;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**   
 * @ClassName: MyPropertiesWithoutAnnotation   
 * @Description: 无@Value注解的pojo 
 * @author: 陈元俊 
 * @date: 2018年10月8日 上午9:58:47  
 */
@ConfigurationProperties(prefix = "selfprops")
public class MyPropertiesWithoutAnnotation {
    private String foo; // 对应selfprops.foo

    private String databasePlatform; // 对应selfprops.database-platform, 注意pojo里面是驼峰，配置文件里面是slash

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    public String getDatabasePlatform() {
        return databasePlatform;
    }

    public void setDatabasePlatform(String databasePlatform) {
        this.databasePlatform = databasePlatform;
    }
    
}
