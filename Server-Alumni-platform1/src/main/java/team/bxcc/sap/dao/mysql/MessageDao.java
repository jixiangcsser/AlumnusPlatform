package team.bxcc.sap.dao.mysql;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import team.bxcc.sap.forum.model.Message;

import java.util.List;

@Mapper
@Component
public interface MessageDao {
    /**
     * 查询用户的消息
     * @param uid
     * @return
     */
    @Select("select pid,reply_username,operation,displayed_content,msg_time from message where uid=#{Uid} and uid!=rid order by msg_time desc")
    @Results({
            @Result(column = "reply_username", property = "replyUsername"),
            @Result(column = "operation", property = "operation"),
            @Result(column = "displayed_content", property = "displayedContent"),
            @Result(column = "msg_time", property = "msgTime"),
            @Result(column = "pid",property = "pid")

    })
    List<Message> ListMessageByUid(@Param("Uid") String uid);

    /**
     * 添加个消息uid为帖子主人的uid.rid为回复人的ID。
     */
    @Insert("insert into message(mid,pid,uid,rid,displayed_content,reply_username,operation) values(#{mid},#{postId},#{userId},#{rid},#{title},#{replyName},#{operation})")
    boolean InsertMessage(@Param("mid") String mid,@Param("postId") String postId ,@Param("userId") String user_id,
                          @Param("rid") String rid,@Param("title") String title,@Param("replyName") String replyname,
                          @Param("operation") String operation);

    /**
     * 查找是否已经点过赞
     */
    @Select("select mid from message where pid=#{pid} and rid=#{uid} and operation=#{operation}")
    String selectLiked(@Param("pid")String pid,@Param("uid") String uid,@Param("operation") String operation);
}
