/**
 * @Title: MyProperties.java
 * @Package: yuanjun.chen.random
 * @Description: 自定义配置文件的属性类
 * @author: 陈元俊
 * @date: 2018年9月30日 上午9:03:51
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.prop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName: MyProperties
 * @Description: 自定义配置文件的属性类，注意可以在配置文件里面内联引用
 * @author: 陈元俊
 * @date: 2018年9月30日 上午9:03:51
 */
@Component
public class MyProperties {
    @Value("${selfprops.my.name}")
    private String myName;

    @Value("${selfprops.my.country}")
    private String myCountry;

    @Value("${selfprops.my.slogan}")
    private String mySlogan;

    @Value("${selfprops.my.petname}")
    private String myPetName;

    @Value("${selfprops.my.petage}")
    private int myPetAge;

    @Value("${selfprops.today.temperature}")
    private int todayTemp;

    public String getMyPetName() {
        return myPetName;
    }

    public void setMyPetName(String myPetName) {
        this.myPetName = myPetName;
    }

    public int getMyPetAge() {
        return myPetAge;
    }

    public void setMyPetAge(int myPetAge) {
        this.myPetAge = myPetAge;
    }

    public int getTodayTemp() {
        return todayTemp;
    }

    public void setTodayTemp(int todayTemp) {
        this.todayTemp = todayTemp;
    }

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public String getMyCountry() {
        return myCountry;
    }

    public void setMyCountry(String myCountry) {
        this.myCountry = myCountry;
    }

    public String getMySlogan() {
        return mySlogan;
    }

    public void setMySlogan(String mySlogan) {
        this.mySlogan = mySlogan;
    }

}
