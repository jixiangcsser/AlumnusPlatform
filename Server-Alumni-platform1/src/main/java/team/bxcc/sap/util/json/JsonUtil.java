package team.bxcc.sap.util.json;

import org.json.JSONObject;

import java.util.Base64;

/**
 * Json 工具集
 * <p>
 * 简易的json操作直接采用JSONObject,不用在这里封装
 *
 * @author FengTao
 * @date 2018/1/19.
 */
public class JsonUtil {

    public static String getJwtParameter(String access_token, String parameter_name) {
        String[] sourceStrArray = access_token.split("\\.");
        JSONObject obj = null;
        try {
            obj = new JSONObject(new String(Base64.getDecoder().decode(sourceStrArray[0].getBytes())));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (obj != null) {
            return obj.get(parameter_name).toString();
        }
        return null;
    }
}
