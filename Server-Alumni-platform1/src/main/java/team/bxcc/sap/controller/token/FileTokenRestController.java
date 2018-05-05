package team.bxcc.sap.controller.token;

import com.aliyuncs.exceptions.ClientException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import team.bxcc.sap.config.HttpStatus;
import team.bxcc.sap.service.AliTokenService;
import team.bxcc.sap.util.annotation.Authorization;
import team.bxcc.sap.util.httpresponse.HttpResponseObj;

/**
 * file token Controller 实现 Restful HTTP 服务
 *
 * @author FengTao
 * @date 2018/2/16.
 */
@RestController
@RequestMapping("/api/file_token")
@Slf4j
public class FileTokenRestController {

    @Autowired
    private AliTokenService aliTokenService;

    /**
     * 获取阿里云文件上传 token
     *
     * @return HttpResponseObj 生成的获取access_token与HTTP响应码
     * <p>
     * Spring Boot默认使用的的json解析框架是jackson
     * 自动将对象解析成json数据
     * <p>
     * 仅支持请求头 content-type : application/json
     * @author FengTao
     * @date 2018/2/16.
     */
    @RequestMapping(method = RequestMethod.GET)
    @Authorization
    public HttpResponseObj get() {
        try {
            return new HttpResponseObj(HttpStatus.OK, "success", aliTokenService.get_token());
        } catch (ClientException e) {
            return new HttpResponseObj(HttpStatus.UNEXPECTED, "Error code: " + e.getErrCode() + "Error message: " + e.getErrMsg() + "RequestId: " + e.getRequestId());
        } catch (Exception ignored) {
            log.error(ignored.toString());
            return new HttpResponseObj(HttpStatus.UNEXPECTED, "unexpected error!");
        }
    }
}
