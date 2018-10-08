package yuanjun.chen.prop;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**   
 * @ClassName: PostInfo   
 * @Description: 复合pojo,注意如果采用手动bind的方式，注解可以不用加，可以变成无任何修饰的完全的pojo  
 * @author: 陈元俊 
 * @date: 2018年10月8日 下午3:07:37  
 */
@ConfigurationProperties
public class PostInfo {

    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "PostInfo [title=" + title + ", content=" + content + "]";
    }

}
