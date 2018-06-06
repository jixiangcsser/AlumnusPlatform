package team.bxcc.sap.controller.forum;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.Bucket;
import com.aliyun.oss.model.GeneratePresignedUrlRequest;
import com.aliyun.oss.model.PutObjectResult;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import team.bxcc.sap.config.HttpStatus;
import team.bxcc.sap.util.httpresponse.HttpResponseObj;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.*;
/**
 * wangEditor富文本编辑器上传图片
 *
 * @author JiXiang
 * @date 2018/5/23.
 */
@RestController
@Component
@RequestMapping("/wangEditor/upload")
public class ForumWangeditorUploadController {

    @RequestMapping(method = RequestMethod.POST)
    public Map<String,String> uploadImgToOSS(MultipartFile file) {
        System.out.println("upload..............");
        Map<String, String> map = new HashMap<String, String>();
        String endpoint = "oss-cn-beijing.aliyuncs.com";
        String accessKeyId = "LTAIVz7TwaSO7otx";
        String accessKeySecret = "RzdMSu84VZqj1PQIRUItDoCaaWj6Iw";
        String realName = UUID.randomUUID().toString()+file.getOriginalFilename() ;
        // 图片存放的真实路径
        String realPath = "http://sse-ustc-wangeditor.oss-cn-beijing.aliyuncs.com/wangEditor/" + realName;
        // 将文件写入指定路径下
        OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        String dir = "wangEditor/";
        String ossUrl = "";
        try {
            InputStream inputStream = file.getInputStream();
            ossUrl = dir + realName;
            //将内容上传到服务器。
            client.putObject("sse-ustc-wangeditor", ossUrl, inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        client.shutdown();
        // 返回图片的URL地址
        Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
        //上传后获取的url地址。
        String url = client.generatePresignedUrl("sse-ustc-wangeditor", ossUrl, expiration).toString();
        //返回是map格式
        map.put("data", url);
        return map;

    }

}
