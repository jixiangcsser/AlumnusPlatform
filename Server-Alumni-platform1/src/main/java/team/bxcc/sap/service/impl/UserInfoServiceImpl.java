package team.bxcc.sap.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import team.bxcc.sap.dao.mysql.UserInfoDao;
import team.bxcc.sap.domain.mysql.UserInfo;
import team.bxcc.sap.service.UserInfoService;
import team.bxcc.sap.service.UserService;

/**
 * UserInfo 实现类
 *
 * @author FengTao
 * @date 2018/2/1.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;


    @Override
    public boolean createUserInfo(UserInfo userInfo) {

        boolean res;
        try {
            res = userInfoDao.createUserInfo(userInfo.getId(), userInfo.getName(), userInfo.getSex(),
                    userInfo.getNation(), userInfo.getHome(), userInfo.getPolitical(), userInfo.getWorkstation(),
                    userInfo.getJob(), userInfo.getUndergraduate(), userInfo.getSpeciality(), userInfo.getDate1(), userInfo.getDate2());
            System.out.println(res);
        } catch (DuplicateKeyException e) {
            throw e;
        }
        return res;
    }

    @Override
    public boolean updateUserInfo(UserInfo userInfo) {
        boolean res;
        try {
            res = userInfoDao.updateUserInfo(userInfo.getId(), userInfo.getName(), userInfo.getSex(),
                    userInfo.getNation(), userInfo.getHome(), userInfo.getPolitical(), userInfo.getWorkstation(),
                    userInfo.getJob(), userInfo.getUndergraduate(), userInfo.getSpeciality(), userInfo.getDate1(), userInfo.getDate2());
        } catch (DuplicateKeyException e) {
            throw e;
        }
        return res;
    }

    @Override
    public UserInfo getUserInfo(String id) {
        return userInfoDao.findUserInfo(id);
    }

}
