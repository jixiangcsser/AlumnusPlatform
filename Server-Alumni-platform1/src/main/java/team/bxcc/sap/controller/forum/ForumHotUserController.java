package team.bxcc.sap.controller.forum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import team.bxcc.sap.config.HttpStatus;
import team.bxcc.sap.domain.mysql.User;
import team.bxcc.sap.service.UserService;
import team.bxcc.sap.util.httpresponse.HttpResponseObj;

import java.util.List;

import static team.bxcc.sap.config.HttpStatus.DATABASE_EXCEPTION;
import static team.bxcc.sap.config.HttpStatus.OK;
/**
 * 活跃用户和最近加入的用户
 *
 * @author JiXiang
 * @date 2018/5/30.
 */
@RestController
@RequestMapping("/api/forum")
public class ForumHotUserController {

    @Autowired
    UserService userService;

    @RequestMapping(value="/hotUsers",method = RequestMethod.GET)
    public HttpResponseObj getHotUsers(@RequestParam int count) {

        try {
            List<User> hotUserList = userService.getHotUsers(count);
            if (hotUserList != null) {
                return new HttpResponseObj(OK, "get hotUserList success", hotUserList);
            }
        } catch (Exception e) {
            return new HttpResponseObj(DATABASE_EXCEPTION, "data Exception");
        }
        return new HttpResponseObj(HttpStatus.UNEXPECTED, "unexpected error!");

    }
    @RequestMapping(value="/recentUsers",method = RequestMethod.GET)
    public HttpResponseObj getRecentUser(@RequestParam int count) {
        try {
            List<User> RecentUserList = userService.getRecentUsers(count);
            if (RecentUserList != null) {
                return new HttpResponseObj(OK, "get reply success", RecentUserList);
            }
        } catch (Exception e) {
            return new HttpResponseObj(DATABASE_EXCEPTION, "data Exception");
        }
        return new HttpResponseObj(HttpStatus.UNEXPECTED, "unexpected error!");

    }
}
