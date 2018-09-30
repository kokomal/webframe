/**
 * @Title: PropertiesTest.java
 * @Package: yuanjun.chen.prop
 * @Description: 配置文件测试
 * @author: 陈元俊
 * @date: 2018年9月30日 上午9:06:07
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.prop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName: PropertiesTest
 * @Description: 配置文件测试
 * @author: 陈元俊
 * @date: 2018年9月30日 上午9:06:07
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PropertiesTest {
    @Autowired
    MyProperties myProperties;

    @Test
    public void testProp() {
        System.out.println("Reading from properties, the name is --- " + myProperties.getMyName());
        System.out.println("Reading from properties, the country is --- " +myProperties.getMyCountry());
        System.out.println("Reading from properties, the slogan is --- " +myProperties.getMySlogan());
    }
    
    @Test
    public void testRandomProp() {
        System.out.println("My pet name is " + myProperties.getMyPetName());
        System.out.println("It is " + myProperties.getMyPetAge() + " years old.");
        System.out.println("Today is " + myProperties.getTodayTemp() + " degrees");
        // 注意随机的配置项一旦初始化，在整个jvm生命周期内不会再变化
        System.out.println("My another pet name is " + myProperties.getMyPetName());
        System.out.println("It is " + myProperties.getMyPetAge() + " years old.");
        System.out.println("Tomorrow is " + myProperties.getTodayTemp() + " degrees");
    }
}
