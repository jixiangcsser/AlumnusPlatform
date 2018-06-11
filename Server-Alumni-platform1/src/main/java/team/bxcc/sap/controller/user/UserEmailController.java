package team.bxcc.sap.controller.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.bxcc.sap.config.ConStants;
import team.bxcc.sap.service.UserService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Ma Mengnan
 * @Description: 邮件认证
 * @Date: Created on 22:28 2018/2/6.
 */

@RestController
@RequestMapping("/api/email")
@Slf4j
public class UserEmailController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public void verifyEmail(@RequestParam String user_Id, HttpServletResponse response) {
        try {

            if (userService.activeUser(user_Id)) {
                try {
                    response.sendRedirect(ConStants.ACTIVED_REDIRECT_URL);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (NullPointerException ignored) {
        } catch (Exception ignored) {
            log.error(ignored.toString());
            try {
                response.getWriter().print("error");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
