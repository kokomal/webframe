package yuanjun.chen.prop;

import org.springframework.boot.context.properties.ConfigurationProperties;

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
