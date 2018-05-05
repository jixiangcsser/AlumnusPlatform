package team.bxcc.sap.service.impl;

import org.json.JSONObject;
import team.bxcc.sap.config.ConStants;
import team.bxcc.sap.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

/**
 * Token 实现类
 *
 * @author FengTao
 * @date 2018/1/19.
 */
@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private HttpServletRequest request;

    @Override
    public String generate_Sha1(String encodedString) {
        String signature = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");//使用SHA1加密算法
            //这里开始加密
            messageDigest.update(encodedString.getBytes("UTF-8"), 0, encodedString.length());
            //这里将byte[]转换成字符串
            signature = DatatypeConverter.printHexBinary(messageDigest.digest());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return signature;
    }

    /**
     * 生成access_token
     *
     * @param hash_alg JSON_WEB_TOKEN
     * @param typ      hash算法名称
     * @return String 生成的access_token
     * token有效时间2个小时, 且根据ip锁定用户
     * @author FengTao
     * @date 2018/1/19.
     */
    @Override
    public String generate_AccessToken(String hash_alg, String typ, String user_name, String user_id) {
        JSONObject obj = new JSONObject();
        UUID uuid = UUID.randomUUID();
        obj.put("typ", typ);
        obj.put("alg", hash_alg);
        obj.put("user", user_name);
        obj.put("user_id", user_id);
        obj.put("uuid", uuid.toString().replace("-", ""));
        // 过期时间为1个小时
        obj.put("timestamp", new Date().getTime() + ConStants.TOKEN_EXPIRES_HOUR);
        //将json数据转换byte类型然后使用base64编码转换成字符串。这里是为了使用加盐！！！所以把json转换成字符串
        String b64obj = new String(Base64.getEncoder().encode(obj.toString().getBytes()));
        // 加盐
        String encodedString = b64obj + request.getRemoteAddr();
        String signature = generate_Sha1(encodedString);
        return b64obj + "." + signature;//signature就是加加盐加密后的值
    }

    @Override
    public boolean check_AccessToken(String access_token) {
        String[] sourceStrArray = access_token.split("\\.");
        JSONObject obj = null;
        try {
            obj = new JSONObject(new String(Base64.getDecoder().decode(sourceStrArray[0].getBytes())));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (obj != null) {
            if (Long.valueOf(obj.get("timestamp").toString()) > new Date().getTime()) {
                // 加盐
                String encodedString = sourceStrArray[0] + request.getRemoteAddr();
                String signature = generate_Sha1(encodedString);
                return signature.equals(sourceStrArray[1]);
            }
        }
        return false;
    }
}
