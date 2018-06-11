package team.bxcc.sap.controller.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;
import team.bxcc.sap.config.ConStants;
import team.bxcc.sap.config.HttpStatus;
import team.bxcc.sap.domain.mysql.User;
import team.bxcc.sap.service.EmailService;
import team.bxcc.sap.service.UserService;
import team.bxcc.sap.util.annotation.Authorization;
import team.bxcc.sap.util.annotation.RequestAccount;
import team.bxcc.sap.util.httpresponse.HttpResponseObj;
import team.bxcc.sap.util.json.JsonUtil;
import team.bxcc.sap.model.AccountModel;

import javax.servlet.http.HttpServletRequest;


/**
 * 用户 Controller 实现 Restful HTTP 服务
 *
 * @author FengTao
 * @date 2018/1/19.
 */
@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private HttpServletRequest requests;

    /**
     * 获取用户是否存在,并且是否被激活！
     *
     * @param username 用户账户 {'user_name': 'xxx'}
     * @return HttpResponseObj 用户是否存在
     * 仅支持请求头 content-type : application/json
     * @author FengTao
     * @date 2018/2/11.
     */
    @RequestMapping(method = RequestMethod.GET)
    public HttpResponseObj get_user(@RequestParam String username) {
        try {

            if (username.matches(ConStants.MATCH_REGULAR_EXP_ACCOUNT)) {
                if (userService.getUser(username)) {
                    if(userService.IsActiveUser(username)){
                        return new HttpResponseObj(HttpStatus.OK, "SUCCESS!");
                    }
                    else {
                        return new HttpResponseObj(HttpStatus.NOT_ACTIVED,"not actived");
                    }
                }
                return new HttpResponseObj(HttpStatus.USERNOTEXIST, "user not exist!");
            }
        } catch (NullPointerException ignored) {
        } catch (Exception ignored) {
            log.error(ignored.toString());
            return new HttpResponseObj(HttpStatus.UNEXPECTED, "unexpected error!");
        }
        return new HttpResponseObj(HttpStatus.WRONG_FORMAT_PARAMETER, "wrong format!");
    }

    /**
     * 创建用户
     *
     * @param user 用户账户与密码与手机号 {'user_name': 'xxx', 'password': 'xxx', 'phone': ''}
     * @return HttpResponseObj 创建用户是否成功
     * 仅支持请求头 content-type : application/json
     * @author FengTao
     * @date 2018/1/19.
     */
    @RequestMapping(method = RequestMethod.POST)
    public HttpResponseObj create(@RequestBody User user) {
        String UserId;
        try {
            if (user.getUser_name().matches(ConStants.MATCH_REGULAR_EXP_ACCOUNT)
                    && (user.getPassword().matches(ConStants.MATCH_WEAK1_REGULAR_EXP_PASSWORD) ||
                    user.getPassword().matches(ConStants.MATCH_WEAK2_REGULAR_EXP_PASSWORD) ||
                    user.getPassword().matches(ConStants.MATCH_WEAK3_REGULAR_EXP_PASSWORD) ||
                    user.getPassword().matches(ConStants.MATCH_MID_REGULAR_EXP_PASSWORD) ||
                    user.getPassword().matches(ConStants.MATCH_STRONG_REGULAR_EXP_PASSWORD)) && user.getPhone().matches(ConStants.MATCH_REGULAR_EXP_PHONE)) {
                    UserId=userService.createUser(user.getUser_name(), user.getPassword(), user.getPhone(), user.getEmail());
                if (UserId!="false") {
                    //异步发送邮件
                    System.out.println("异步发送邮件");
                    emailService.sendActivedEmail(user.getUser_name(), user.getEmail(),UserId);
                    return new HttpResponseObj(HttpStatus.OK, "create user success!");
                } else {
                    return new HttpResponseObj(HttpStatus.DATABASE_EXCEPTION, "create user failed!");
                }
            }
        } catch (NullPointerException ignored) {
        } catch (DuplicateKeyException ignored) {
            return new HttpResponseObj(HttpStatus.DuplicateKeyException, "user already exist!");
        } catch (Exception ignored) {
            log.error(ignored.toString());
            return new HttpResponseObj(HttpStatus.UNEXPECTED, "unexpected error!");
        }

        return new HttpResponseObj(HttpStatus.WRONG_FORMAT_PARAMETER, "invalid input format!");
    }

    /**
     * 更改用户
     *
     * @param user 用户名和新密码 {'user_name': 'xxx','password': 'xxx'}
     * @return HttpResponseObj 更改用户信息是否成功
     * 仅支持请求头 content-type : application/json
     * @author FengTao
     * @date 2018/1/19.
     */
    @RequestMapping(method = RequestMethod.PUT)
    @Authorization
    public HttpResponseObj update(@RequestBody AccountModel user) {
        try {
            if ((user.getPassword().matches(ConStants.MATCH_WEAK1_REGULAR_EXP_PASSWORD) ||
                    user.getPassword().matches(ConStants.MATCH_WEAK2_REGULAR_EXP_PASSWORD) ||
                    user.getPassword().matches(ConStants.MATCH_WEAK3_REGULAR_EXP_PASSWORD) ||
                    user.getPassword().matches(ConStants.MATCH_MID_REGULAR_EXP_PASSWORD) ||
                    user.getPassword().matches(ConStants.MATCH_STRONG_REGULAR_EXP_PASSWORD))
                    && !user.getPassword().equals("")) {
                if (userService.updateUser(user.getUser_name(), user.getPassword())) {
                    return new HttpResponseObj(HttpStatus.OK, "update user success!");
                } else {
                    return new HttpResponseObj(HttpStatus.DATABASE_EXCEPTION, "update user failed!");
                }
            }
        } catch (NullPointerException ignored) {
        } catch (Exception ignored) {
            log.error(ignored.toString());
            return new HttpResponseObj(HttpStatus.UNEXPECTED, "unexpected error!");
        }
        return new HttpResponseObj(HttpStatus.WRONG_FORMAT_PARAMETER, "invalid input format!");
    }

    /**
     * 删除用户
     *
     * @param user 用户账户与密码 {'user_name': 'xxx', 'password': 'xxx'}
     * @return HttpResponseObj 删除用户是否成功
     * 仅支持请求头 content-type : application/json
     * @author FengTao
     * @date 2018/1/19.
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public HttpResponseObj delete(@RequestAccount AccountModel user) {
        try {
            if (userService.deleteUser(user.getUser_name(), user.getPassword())) {
                return new HttpResponseObj(HttpStatus.OK, "delete user success!");
            } else {
                return new HttpResponseObj(HttpStatus.DATABASE_EXCEPTION, "delete user failed!");
            }
        } catch (NullPointerException ignored) {
        } catch (Exception ignored) {
            log.error(ignored.toString());
            return new HttpResponseObj(HttpStatus.UNEXPECTED, "unexpected error!");
        }
        return new HttpResponseObj(HttpStatus.WRONG_FORMAT_PARAMETER, "invalid input format!");
    }
}
