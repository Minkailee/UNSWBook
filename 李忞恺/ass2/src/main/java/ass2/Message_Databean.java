package ass2;

import java.util.ArrayList;
import java.util.Date;

public class Message_Databean {
    private Date publish_date;
    private Integer publisher_user_id;
    private String content;
    private String href;
    private ArrayList<Integer> liked_by = new ArrayList<Integer>();

    public Date getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(Date publish_date) {
        this.publish_date = publish_date;
    }

    public Integer getPublisher_user_id() {
        return publisher_user_id;
    }

    public void setPublisher_user_id(Integer publisher_user_id) {
        this.publisher_user_id = publisher_user_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public ArrayList<Integer> getLiked_by() {
        return liked_by;
    }

    public void setLiked_by(ArrayList<Integer> liked_by) {
        this.liked_by = liked_by;
    }

    public Message_Databean(Date publish_date, Integer publisher_user_id, String content, String href, ArrayList<Integer> liked_by) {
        this.publish_date = publish_date;
        this.publisher_user_id = publisher_user_id;
        this.content = content;
        this.href = href;
        this.liked_by = liked_by;
    }
}
