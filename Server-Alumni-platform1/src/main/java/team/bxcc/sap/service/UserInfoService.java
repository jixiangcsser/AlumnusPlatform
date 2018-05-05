package team.bxcc.sap.service;

import team.bxcc.sap.domain.mysql.UserInfo;

/**
 * 用户基本信息操作逻辑接口类
 *
 * @author FengTao
 * @date 2018/2/1.
 */
public interface UserInfoService {
    /**
     * 创建用户基本信息
     */
    boolean createUserInfo(UserInfo userInfo);

    /**
     * 更改用户基本信息
     */
    boolean updateUserInfo(UserInfo userInfo);

    /**
     * 获取用户基本信息
     */
    UserInfo getUserInfo(String id);
}
