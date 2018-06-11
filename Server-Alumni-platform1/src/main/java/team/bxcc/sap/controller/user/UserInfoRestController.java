package team.bxcc.sap.controller.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import team.bxcc.sap.config.HttpStatus;
import team.bxcc.sap.domain.mysql.UserInfo;
import team.bxcc.sap.service.UserInfoService;
import team.bxcc.sap.service.UserService;
import team.bxcc.sap.util.annotation.Authorization;
import team.bxcc.sap.util.annotation.RequestUserInfo;
import team.bxcc.sap.util.httpresponse.HttpResponseObj;

/**
 * 用户 Controller 实现 Restful HTTP 服务
 *
 * @author FengTao
 * @date 2018/1/19.
 */
@RestController
@RequestMapping("/api/userinfo")
@Slf4j
public class UserInfoRestController {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private UserService userService;
    /**
     * 获取用户基本信息
     *
     * @return UserInfo 用户基本信息
     * 仅支持请求头 content-type : application/json
     * @author FengTao
     * @date 2018/2/1.
     */
    @RequestMapping(method = RequestMethod.GET)
    @Authorization
    public HttpResponseObj get_userinfo(@RequestParam String id, @RequestParam boolean return_body) {
        System.out.println("id="+id);
        try {
            if (id.equals("")) {
                return new HttpResponseObj(HttpStatus.WRONG_FORMAT_PARAMETER, "invalid input format!");
            }
            UserInfo userInfo = userInfoService.getUserInfo(id);
            if (userInfo == null) {
                return new HttpResponseObj(HttpStatus.USERNOTEXIST, "userinfo not exist!");
            } else {
                if (return_body) {
                    return new HttpResponseObj(HttpStatus.OK, "success!", userInfo);
                } else {
                    return new HttpResponseObj(HttpStatus.OK, "success!");
                }
            }
        } catch (NullPointerException ignored) {
            return new HttpResponseObj(HttpStatus.WRONG_FORMAT_PARAMETER, "invalid input format!");
        } catch (Exception ignored) {
            log.error(ignored.toString());
            return new HttpResponseObj(HttpStatus.UNEXPECTED, "unexpected error!");
        }
    }

    /**
     * 更改用户基本信息
     *
     * @return UserInfo 用户基本信息
     * 仅支持请求头 content-type : application/json
     * @author FengTao
     * @date 2018/2/1.
     */
    @RequestMapping(method = RequestMethod.PUT)
    @Authorization
    public HttpResponseObj update_userinfo(@RequestUserInfo UserInfo userinfo) {
        try {

            if (userInfoService.updateUserInfo(userinfo)){
                return new HttpResponseObj(HttpStatus.OK, "update userinfo success!");
            } else {
                return new HttpResponseObj(HttpStatus.DATABASE_EXCEPTION, "update user failed!");
            }
        } catch (NullPointerException ignored) {
        } catch (DuplicateKeyException ignored) {
            return new HttpResponseObj(HttpStatus.DuplicateKeyException, "userinfo already exist!");
        } catch (Exception ignored) {
            log.error(ignored.toString());
            return new HttpResponseObj(HttpStatus.UNEXPECTED, "unexpected error!");
        }
        return new HttpResponseObj(HttpStatus.WRONG_FORMAT_PARAMETER, "invalid input format!");
    }

    /**
     * 增加用户基本信息
     *
     * @param userinfo 用户基本信息 {'name': 'xxx', 'sex': 1, 'home': '' ....}
     * @return HttpResponseObj 创建用户基本信息是否存储成功
     * 仅支持请求头 content-type : application/json
     * @author FengTao
     * @date 2018/2/1.
     */
    @RequestMapping(method = RequestMethod.POST)
    @Authorization
    public HttpResponseObj create(@RequestUserInfo UserInfo userinfo) {
        try {

            if (userInfoService.createUserInfo(userinfo)&&userService.updateHeadUrlFlag(userinfo.getId())) {

                return new HttpResponseObj(HttpStatus.OK, "create userinfo success!");
            } else {

                return new HttpResponseObj(HttpStatus.DATABASE_EXCEPTION, "create user failed!");
            }

        } catch (NullPointerException ignored) {
        } catch (DuplicateKeyException ignored) {
            return new HttpResponseObj(HttpStatus.DuplicateKeyException, "userinfo already exist!");
        } catch (Exception ignored) {
            log.error(ignored.toString());
            return new HttpResponseObj(HttpStatus.UNEXPECTED, "unexpected error!");
        }
        return new HttpResponseObj(HttpStatus.WRONG_FORMAT_PARAMETER, "invalid input format!");
    }
}
