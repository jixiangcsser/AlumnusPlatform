package team.bxcc.sap.dao.mysql;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import team.bxcc.sap.domain.mysql.User;
import team.bxcc.sap.forum.model.Reply;

import java.util.List;

@Mapper
@Component
public interface ReplyDao {
    @Insert("INSERT INTO reply(rid,pid,uid,content,reply_time) VALUES(#{rid},#{pid},#{uid},#{content},#{replyTime})")
    boolean addReply(@Param("rid") String rid,@Param("pid") String pid,@Param("uid") String uid,@Param("content")String content,@Param("replyTime") String replyTime);


    /**
     * 一对一关系中需要查找的值
     * @param uid
     * @return
     */
    @Select("SELECT id,user_name,headUrlFlag from user where id=#{uid}")
    User findUser(@Param("uid") String uid);

    /**
     * 获取当前帖子所有的回复
     * @param pid
     * @return
     */
    @Select("SELECT * FROM reply WHERE pid=#{pid} order by reply_time desc")
    @Results(
            {
                    @Result(id = true,column = "rid", property = "rid"),
                    @Result(column = "content", property = "content"),
                    @Result(column = "reply_time", property = "replyTime"),
                    @Result(column = "uid", property = "user",
                            one = @One(select = "team.bxcc.sap.dao.mysql.ReplyDao.findUser"))
            })
    List<Reply> getReply(@Param("pid") String pid);
}
