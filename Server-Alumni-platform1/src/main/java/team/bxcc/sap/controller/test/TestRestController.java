package team.bxcc.sap.controller.test;

import org.springframework.web.bind.annotation.*;
import team.bxcc.sap.config.HttpStatus;
import team.bxcc.sap.domain.mysql.User;
import team.bxcc.sap.util.annotation.Authorization;
import team.bxcc.sap.util.httpresponse.HttpResponseObj;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sts.model.v20150401.AssumeRoleRequest;
import com.aliyuncs.sts.model.v20150401.AssumeRoleResponse;

/**
 * 测试控制器
 *
 * @author FengTao
 * @date 2018/1/19.
 */
@RestController
@RequestMapping("/api/test")
public class TestRestController {

    //只要在方法上加上@Authorization注解,该方法就会自动校验access_token,拒绝非法请求
    @RequestMapping(method = RequestMethod.GET)
//    @Authorization
    public HttpResponseObj test() {
        return new HttpResponseObj(HttpStatus.TEST, "it's a test!");
    }

    // 支持application/x-www-form-urlencoded;charset=utf-8
    @RequestMapping(method = RequestMethod.DELETE)
    public HttpResponseObj test3(@RequestParam int id, @RequestParam String name) {
        System.out.println(id);
        System.out.println(name);
        return new HttpResponseObj(HttpStatus.TEST, "it's a test!");
    }

    //只要在参数上加上@RequestBody注解,传入的json对象会被自动转换成对应Dao对象, 仅支持application/json
    //两种请求头都支持
    @RequestMapping(method = RequestMethod.POST)
    public HttpResponseObj test2(@RequestBody User user) {
        if (user == null) {
            System.out.println("参数不完整!");
        } else {
            System.out.println(user);
        }
        return new HttpResponseObj(HttpStatus.TEST, "it's a test!");
    }
}

