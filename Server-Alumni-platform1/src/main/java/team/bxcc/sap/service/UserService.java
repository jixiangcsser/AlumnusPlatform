package team.bxcc.sap.service;

import team.bxcc.sap.domain.mysql.User;

import java.util.List;

/**
 * 用户查询逻辑接口类
 *
 * @author FengTao
 * @date 2018/1/19.
 */
public interface UserService {
    /**
     * 查询用户信息
     */
    User findUser(String user_name, String password);

    /**
     * 查询用户是否存在，并返回用户信息
     */
    User getUserInfo(String user_name);

    /**
     * 查询用户是否存在
     */
    boolean getUser(String user_name);

    /**
     * 创建用户
     */
    boolean createUser(String user_name, String password, String phone, String email);

    /**
     * 更改用户信息
     */
    boolean updateUser(String user_name, String new_password);

    /**
     * 用户激活
     */
    boolean activeUser(String user_name);

    /**
     * 删除用户
     */
    boolean deleteUser(String user_name, String password);

    /**
     * 修改用户的HeadUrl
     *
     */
    boolean updateHeadUrlFlag(String user_id);

    /**
     * 获取活跃用户
     */
    List<User> getHotUsers(int count);

    /**
     * 获取最近加入用户
     */
    List<User> getRecentUsers(int count);
}
