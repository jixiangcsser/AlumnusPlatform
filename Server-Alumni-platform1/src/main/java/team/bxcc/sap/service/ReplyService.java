package team.bxcc.sap.service;

import team.bxcc.sap.forum.model.Reply;

import java.util.List;

public interface ReplyService {
    boolean addreply(Reply reply,String user_id,String post_id);
    // 读取帖子的评论
    List<Reply> getReply(String pid);
}
