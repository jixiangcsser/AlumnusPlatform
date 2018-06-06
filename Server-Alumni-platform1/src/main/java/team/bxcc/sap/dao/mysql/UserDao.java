package team.bxcc.sap.dao.mysql;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.bxcc.sap.domain.mysql.User;

import java.sql.Timestamp;
import java.util.List;

/**
 * 用户 DAO 接口类
 *
 * @author FengTao
 * @date 2018/1/19.
 */
@Mapper // 标志为 Mybatis 的 Mapper
@Component
public interface UserDao {
    /**
     * 查询用户基本信息
     */
    @Select("SELECT * FROM user WHERE user_name = #{user_name} AND password = #{password}")
    User findUser(@Param("user_name") String user_name, @Param("password") String password);

    /**
     * 查询用户是否存在
     */
    @Select("SELECT COUNT(id) FROM user WHERE user_name = #{user_name}")
    boolean getUser(@Param("user_name") String user_name);

    /**
     * 查询用户基本信息(无需密码)
     */

    @Select("SELECT * FROM user WHERE user_name = #{user_name}")
    User getUserInfo(@Param("user_name") String user_name);

    /**
     * 创建用户
     */
    @Insert("INSERT INTO user (id, user_name, password, phone,email, timestamp) VALUES (#{id},#{user_name},#{password},#{phone},#{email},#{timestamp})")
    boolean createUser(@Param("id") String id, @Param("user_name") String user_name, @Param("password") String password, @Param("phone") String phone, @Param("email") String email, @Param("timestamp") Timestamp timestamp);

    /**
     * 更改用户信息
     */
    @Update("UPDATE user SET password=#{password} WHERE user_name =#{user_name}")
    boolean updateUser(@Param("user_name") String user_name, @Param("password") String password);

    /**
     * 激活
     */
    @Update("UPDATE user SET actived='1' WHERE user_name =#{user_name}")
    boolean activeUser(@Param("user_name") String user_name);

    /**
     * 删除用户
     */
    @Delete("DELETE FROM user WHERE user_name =#{user_name} AND password = #{password}")
    boolean deleteUser(@Param("user_name") String user_name, @Param("password") String password);

    /**
     * 标志用户的头像已经上传
     * @param id
     */
    @Update("UPDATE user SET headUrlFlag=1 WHERE id =#{Uid}")
    boolean updateHeadUrl(@Param("Uid") String id );

    /**
     * 查看近期活跃用户的信息
     * @param count
     * @return
     */
    @Select("select id,user_name,headUrlFlag from user,post where user.id=post.uid group by uid order by count(*) desc limit #{count}")
    List<User> getHotUsers(@Param("count") int count);

    /**
     * 获取近期加入的用户
     * @param count
     * @return
     */
    @Select("select user_name,headUrlFlag,id from user order by timestamp desc limit #{count}")
    List<User> getRecentUsers(@Param("count") int count);

    /**
     * 根据用户id获取用户名
     */
    @Select("select user_name from user where id=#{Id}")
    String getNamebyId(@Param("Id") String id);
}
