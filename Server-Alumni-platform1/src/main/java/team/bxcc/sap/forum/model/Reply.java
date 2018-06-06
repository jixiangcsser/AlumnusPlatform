package team.bxcc.sap.forum.model;

import team.bxcc.sap.domain.mysql.User;

import java.util.List;
/**
 * 用户帖子的详细信息 model 类
 * @author JiXiang
 * @date 2018/5/10.
 */
public class Reply {
    private String rid;
    private String content;
    //两个外键
    private Post post;
    private User user;


    //private String pid;



    //private String user_id;
    private String replyTime;
    private List<Comment> commentList;

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    //public String getPid() {
   //     return pid;
   // }

    //public void setPid(String pid) {
    //    this.pid = pid;
    //}

    public String getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(String replyTime) {
        this.replyTime = replyTime;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }


   /* public String getUser_id() {
        return user_id;
    }
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }*/

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String toString(){
        return "Reply{"+
                ",rid="+rid+",content"+content+
                ",Post="+post+",User="+user+
                ",replyTime="+replyTime+
                ",commentList="+commentList;
    }




}

