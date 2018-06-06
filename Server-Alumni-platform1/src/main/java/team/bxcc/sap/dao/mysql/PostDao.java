package team.bxcc.sap.dao.mysql;

import javafx.geometry.Pos;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import team.bxcc.sap.domain.mysql.User;
import team.bxcc.sap.forum.model.PageBean;
import team.bxcc.sap.forum.model.Post;

import java.sql.Timestamp;
import java.util.List;

@Mapper
@Component
public interface PostDao {

    /**
     * 创建用户
     */
    @Insert("INSERT INTO post (pid,title, content, publish_time,reply_time, reply_count" +
            ",like_count,scan_count,uid) VALUES " +
            "(#{pid},#{title},#{content},#{publish_time},#{reply_time},#{reply_count}," +
            "#{like_count},#{scan_count},#{uid})")
    boolean insertPost(@Param("pid") String pid,@Param("title") String Title,
                       @Param("content") String content,@Param("publish_time") String publish_time,
                       @Param("reply_time") String reply_time,@Param("reply_count") Integer reply_count,
                       @Param("like_count") Integer like_count,
                       @Param("scan_count") Integer scan_count,@Param("uid") String uid);

    /**
     * 查询所有的帖子的个数
     */
    @Select("SELECT COUNT(*) from post")
    int selectPostCount();
    /**
     * 查询用户帖子的总数
     */
    @Select("SELECT COUNT(*) from post where uid=#{uid}")
    int selectPostCountByUid(@Param("uid") String uid);

    /**
     * 分页查询
     */
    @Select("SELECT id,user_name,headUrlFlag from user where id=#{uid}")
    User findUser(@Param("uid") String uid);
    @Select("SELECT u.id,u.user_name,p.pid,p.title,p.publish_time,p.reply_time,p.reply_count," +
            "p.like_count," +
            "p.scan_count from post p join user u on p.uid = u.id order by p.reply_time desc limit #{offset},#{limit}")
    @Results(
            {
                    @Result(id = true,column = "pid", property = "pid"),
                    @Result(column = "title", property = "title"),
                    @Result(column = "reply_time", property = "replyTime"),
                    @Result(column = "reply_count", property = "replyCount"),
                    @Result(column = "like_count", property = "likeCount"),
                    @Result(column = "publish_time", property = "publishTime"),
                    @Result(column = "scan_count", property = "scanCount"),
                    @Result(column = "id", property = "user",
                    one = @One(select = "team.bxcc.sap.dao.mysql.PostDao.findUser"))
            })
    List<Post> listPostByTime(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 根据用户分页查询
     */

    @Select("SELECT u.id,u.user_name,p.pid,p.title,p.publish_time,p.reply_time,p.reply_count," +
            "p.like_count," +
            "p.scan_count from post p join user u on p.uid = u.id and uid=#{uid} order by p.reply_time desc limit #{offset},#{limit}")
    @Results(
            {
                    @Result(id = true,column = "pid", property = "pid"),
                    @Result(column = "title", property = "title"),
                    @Result(column = "reply_time", property = "replyTime"),
                    @Result(column = "reply_count", property = "replyCount"),
                    @Result(column = "like_count", property = "likeCount"),
                    @Result(column = "publish_time", property = "publishTime"),
                    @Result(column = "scan_count", property = "scanCount"),
                    @Result(column = "id", property = "user",
                            one = @One(select = "team.bxcc.sap.dao.mysql.PostDao.findUser"))
            })
    List<Post> listPostByUserTime(@Param("offset") int offset, @Param("limit") int limit,@Param("uid") String uid);

    /**
     * 根据用热度去查询帖子
     */
    @Select("SELECT u.id,u.user_name,p.pid,p.title,p.publish_time,p.reply_time,p.reply_count," +
            "p.like_count," +
            "p.scan_count from post p join user u on p.uid = u.id order by p.reply_count desc limit #{offset},#{limit}")
    @Results(
            {
                    @Result(id = true,column = "pid", property = "pid"),
                    @Result(column = "title", property = "title"),
                    @Result(column = "reply_time", property = "replyTime"),
                    @Result(column = "reply_count", property = "replyCount"),
                    @Result(column = "like_count", property = "likeCount"),
                    @Result(column = "publish_time", property = "publishTime"),
                    @Result(column = "scan_count", property = "scanCount"),
                    @Result(column = "id", property = "user",
                            one = @One(select = "team.bxcc.sap.dao.mysql.PostDao.findUser"))
            })
    List<Post> listPostByHeat(@Param("offset") int offset, @Param("limit") int limit);
    /**
     * 根据用户的pid查询帖子
     */

    @Select("SELECT u.id,u.user_name,p.pid,p.title,p.content,p.publish_time,p.reply_time,p.reply_count,p.like_count,p.scan_count " +
            "from post p join user u on p.uid = u.id and pid=#{pid}")

    @Results(
            {

                    @Result(column = "reply_time", property = "replyTime"),
                    @Result(column = "reply_count", property = "replyCount"),
                    @Result(column = "like_count", property = "likeCount"),
                    @Result(column = "publish_time", property = "publishTime"),
                    @Result(column = "scan_count", property = "scanCount"),

                    @Result(column = "id", property = "user",
                            one = @One(select = "team.bxcc.sap.dao.mysql.PostDao.findUser"))

            })
    Post getpost(@Param("pid") String pid);


    /**
     * 更新帖子的回复数
     */
    @Update("update post set reply_count=reply_count+1 where pid=#{pid}")
    boolean updateReplyCount(@Param("pid") String post_id);

    /**
     * 更新帖子的浏览数
     *
     */
    @Update("update post set scan_count=scan_count+1 where pid=#{pid}")
    boolean updateScanCount(@Param("pid") String post_id);

    /**
     * 更新帖子的回复数和回复时间
     * @param post_id
     */
    @Update("update post set reply_count=reply_count+1 ,reply_time=#{ReplyTime} where pid=#{pid}")
    boolean updateReplyCountAndReplyTime(@Param("pid") String post_id,@Param("ReplyTime") String replyTime);
    /**
     * 更新帖子的点赞数
     */

    @Update("update post set like_count=like_count+1 where pid=#{pid}")
    boolean updateLikedCount(@Param("pid") String post_id);

    /**
     * 根据帖子的id获取帖子的名字
     */
    @Select("select uid,title from post where pid=#{pid} ")
    Post getTitleUidbyId(@Param("pid") String pid);


}
