package team.bxcc.sap.controller.token;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import team.bxcc.sap.config.HttpStatus;
import team.bxcc.sap.domain.mysql.User;
import team.bxcc.sap.service.TokenService;
import team.bxcc.sap.service.UserService;
import team.bxcc.sap.util.annotation.RequestAccount;
import team.bxcc.sap.util.httpresponse.HttpResponseObj;
import team.bxcc.sap.model.AccountModel;


/**
 * token Controller 实现 Restful HTTP 服务
 *
 * @author FengTao
 * @date 2018/1/19.
 */
@RestController
@RequestMapping("/api/token")
@Slf4j
public class TokenRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    /**
     * 获取access_token
     *
     * @param account 用户账户与密码 {'user_name': 'xxx', 'password': 'xxx'}
     * @return HttpResponseObj 生成的获取access_token与HTTP响应码
     * <p>
     * Spring Boot默认使用的的json解析框架是jackson
     * 自动将对象解析成json数据
     * <p>
     * 仅支持请求头 content-type : application/json
     * @author FengTao
     * @date 2018/1/19.
     */
    @RequestMapping(method = RequestMethod.POST)
    public HttpResponseObj login(@RequestAccount AccountModel account) {
        try {
            User user = userService.findUser(account.getUser_name(), account.getPassword());
            if (user.getActived().equals("1")) { //如果用户已经激活，就返回一个token!
                return new HttpResponseObj(HttpStatus.OK, tokenService.generate_AccessToken("JWT", "HS256", account.getUser_name(), user.getId()));
            } else {
                return new HttpResponseObj(HttpStatus.NOT_ACTIVED, "account not actived");
            }
        } catch (NullPointerException ignored) {
            return new HttpResponseObj(HttpStatus.WRONG_FORMAT_PARAMETER, "invalid username or password!");
        } catch (Exception ignored) {
            log.error(ignored.toString());
            return new HttpResponseObj(HttpStatus.UNEXPECTED, "unexpected error!");
        }
    }
}