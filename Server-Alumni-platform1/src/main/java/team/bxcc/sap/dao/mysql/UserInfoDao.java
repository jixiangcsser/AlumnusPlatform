package team.bxcc.sap.dao.mysql;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import team.bxcc.sap.domain.mysql.UserInfo;

import java.sql.Timestamp;

/**
 * 用户Info DAO 接口类
 *
 * @author FengTao
 * @date 2018/2/1.
 */
@Mapper // 标志为 Mybatis 的 Mapper
@Component
public interface UserInfoDao {

    /**
     * 创建用户
     */
    @Insert("INSERT INTO userinfo (id, name, sex, nation, home, political, workstation, job, undergraduate, " +
            "speciality, date1, date2) VALUES (#{id},#{name},#{sex},#{nation},#{home},#{political},#{workstation}" +
            ",#{job},#{undergraduate},#{speciality},#{date1},#{date2})")
    boolean createUserInfo(@Param("id") String id, @Param("name") String name, @Param("sex") int sex,
                           @Param("nation") int nation, @Param("home") String home, @Param("political") int political,
                           @Param("workstation") String workstation, @Param("job") String job, @Param("undergraduate") String undergraduate,
                           @Param("speciality") String speciality, @Param("date1") Timestamp date1, @Param("date2") Timestamp date2);

    /**
     * 更改用户信息
     */
    @Update("UPDATE userinfo SET name=#{name},sex=#{sex},nation=#{nation},home=#{home},political=#{political}," +
            "workstation=#{workstation},job=#{job},undergraduate=#{undergraduate},speciality=#{speciality},date1=#{date1},date2=#{date2} WHERE id =#{id}")
    boolean updateUserInfo(@Param("id") String id, @Param("name") String name, @Param("sex") int sex,
                           @Param("nation") int nation, @Param("home") String home, @Param("political") int political,
                           @Param("workstation") String workstation, @Param("job") String job, @Param("undergraduate") String undergraduate,
                           @Param("speciality") String speciality, @Param("date1") Timestamp date1, @Param("date2") Timestamp date2);

    /**
     * 获取用户基本信息
     */
    @Select("SELECT * FROM userinfo WHERE id = #{id}")
    UserInfo findUserInfo(@Param("id") String id);
}
