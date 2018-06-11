package team.bxcc.sap.controller.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.bxcc.sap.config.HttpStatus;
import team.bxcc.sap.domain.mysql.User;
import team.bxcc.sap.model.AccountModel;
import team.bxcc.sap.service.EmailService;
import team.bxcc.sap.service.TokenService;
import team.bxcc.sap.service.UserService;
import team.bxcc.sap.util.httpresponse.HttpResponseObj;


@RestController
@RequestMapping("/api/check_code")
@Slf4j
public class CheckCodeEmailController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @RequestMapping(method = RequestMethod.GET)
    public HttpResponseObj verifyCode(@RequestParam String user_name, @RequestParam String code) {
        try {
            if (emailService.verifyCodeEmail(user_name, code)) {
                User user = userService.getUserInfo(user_name);
                return new HttpResponseObj(HttpStatus.OK, tokenService.generate_AccessToken("JWT", "HS256", user.getUser_name(), user.getId()));
            }
        } catch (NullPointerException ignored) {
        } catch (Exception ignored) {
            log.error(ignored.toString());
        }
        return new HttpResponseObj(HttpStatus.UNEXPECTED, "error!");
    }

    @RequestMapping(method = RequestMethod.POST)
    public HttpResponseObj sendEmail(@RequestBody AccountModel user) {
        try {
            emailService.sendCodeEmail(user.getUser_name());
        } catch (NullPointerException ignored) {
        } catch (Exception ignored) {
            log.error(ignored.toString());
        }
        return new HttpResponseObj(HttpStatus.OK, "send success!");
    }
}
