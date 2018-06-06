package team.bxcc.sap.forum.model;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 访问者评论或是点赞的消息
 * @author Jixiang
 * @date 2018/5/28.
 */
public class Message {
    private String mid;
    private String uid;
    private String pid;
    private String rid;//在你帖子中说话的人的uid
    private String replyUsername;
    private String operation;
    private String displayedContent;



    private Date  msgTime;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getReplyUsername() {
        return replyUsername;
    }

    public void setReplyUsername(String replyUsername) {
        this.replyUsername = replyUsername;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getDisplayedContent() {
        return displayedContent;
    }

    public void setDisplayedContent(String displayedContent) {
        this.displayedContent = displayedContent;
    }

    public Date getMsgTime() {
        return msgTime;
    }

    public void setMsgTime(Date msgTime) {
        this.msgTime = msgTime;
    }
    @Override
    public String toString(){
        return "Message={"+
                "mid="+mid+
                "uid="+uid+
                "pid="+pid+
                "rid="+rid+
                "operation="+operation+
                "msgTime="+msgTime+
                "displayContent"+displayedContent;
    }
}
