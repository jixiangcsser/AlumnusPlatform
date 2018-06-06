package team.bxcc.sap.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.bxcc.sap.dao.mysql.MessageDao;
import team.bxcc.sap.dao.mysql.PostDao;
import team.bxcc.sap.dao.mysql.ReplyDao;
import team.bxcc.sap.dao.mysql.UserDao;
import team.bxcc.sap.domain.mysql.User;
import team.bxcc.sap.forum.model.Post;
import team.bxcc.sap.forum.model.Reply;
import team.bxcc.sap.service.PostService;
import team.bxcc.sap.service.ReplyService;
import team.bxcc.sap.util.time.FormatTime;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static team.bxcc.sap.config.ConStants.OPERATION_REPLY;
/**
 * 访问者评论 实现类
 *
 * @author JiXiang
 * @date 2018/5/28.
 */
@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    ReplyDao replyDao;
    @Autowired
    PostDao postDao;
    @Autowired
    UserDao userDao;
    @Autowired
    MessageDao messageDao;
    //往数据库表中添加评论
    @Override
    public boolean addreply(Reply reply,String replyUser_id,String post_id) {

        reply.setUser(new User(replyUser_id));
        reply.setPost(new Post(post_id));
        reply.setReplyTime(FormatTime.formatDate(new Date()));
        String rid=UUID.randomUUID().toString().replace("-", "");//设置rid号
        reply.setRid(rid);
        //增加回复的
        boolean successOrFailure=replyDao.addReply(reply.getRid(),reply.getPost().getPid(),reply.getUser().getId(),reply.getContent(),reply.getReplyTime());
        //更新回复的数量
        boolean updateSuccess=postDao.updateReplyCountAndReplyTime(post_id,reply.getReplyTime());

        //插入一条消息
        Post post=postDao.getTitleUidbyId(post_id);

        String replyname=userDao.getNamebyId(replyUser_id);
        String mid=UUID.randomUUID().toString().replace("-", "");//设置mid号
        //回复的信息存入信息中。
        if(!post.getUid().equals(replyUser_id)) {//如果回复人和帖子主人一样就不用加进去了

            messageDao.InsertMessage(mid, post_id, post.getUid(), replyUser_id, post.getTitle(), replyname, OPERATION_REPLY);
        }
        return successOrFailure&&updateSuccess;
    }

    @Override
    public List<Reply> getReply(String pid) {

        List<Reply> reply1=replyDao.getReply(pid);
        return reply1;
    }


}
