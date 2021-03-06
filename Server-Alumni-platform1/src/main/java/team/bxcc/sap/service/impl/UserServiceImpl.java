package team.bxcc.sap.service.impl;

import org.springframework.dao.DuplicateKeyException;
import team.bxcc.sap.config.ConStants;
import team.bxcc.sap.dao.mysql.UserDao;
import team.bxcc.sap.domain.mysql.User;
import team.bxcc.sap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 用户查询逻辑实现类
 *
 * @author FengTao
 * @date 2018/1/19.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TokenServiceImpl tokenService;

    @Autowired
    private UserDao userDao;

    private String sha1Password(String password) {
        return tokenService.generate_Sha1(password + ConStants.PASSWORD_SHA256_SALT);
    }


    @Override
    public User findUser(String user_name, String password) {
        return userDao.findUser(user_name, sha1Password(password));
    }

    @Override
    public User getUserInfo(String user_name) {
        return userDao.getUserInfo(user_name);
    }

    @Override
    public boolean getUser(String user_name) {
        return userDao.getUser(user_name);
    }

    @Override
    public String createUser(String user_name, String password, String phone, String email) {
        String id = UUID.randomUUID().toString().replace("-", "");
        boolean res;
        try {
            res = userDao.createUser(id, user_name, sha1Password(password), phone, email, new Timestamp(new Date().getTime()));
        } catch (DuplicateKeyException e) {
            throw e;
        }
        if(res==true){
            return id;
        }
        else
            return "false";
    }

    @Override
    public boolean updateUser(String user_name, String new_password) {
        return userDao.updateUser(user_name, sha1Password(new_password));
    }

    @Override
    public boolean activeUser(String user_Id) {

        return userDao.activeUser(user_Id);
    }

    @Override
    public boolean IsActiveUser(String user_name) {

        if(userDao.IsActiveUser(user_name)==0){
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteUser(String user_name, String password) {
        return userDao.deleteUser(user_name, sha1Password(password));
    }

    @Override
    public boolean updateHeadUrlFlag(String user_id) {
        return userDao.updateHeadUrl(user_id);
    }

    @Override
    public List<User> getHotUsers(int count) {

        return userDao.getHotUsers(count);
    }

    @Override
    public List<User> getRecentUsers(int count) {
        return userDao.getRecentUsers(count);
    }


}
