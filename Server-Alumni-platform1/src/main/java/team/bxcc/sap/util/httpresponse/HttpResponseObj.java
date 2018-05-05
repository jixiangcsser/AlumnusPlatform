package team.bxcc.sap.util.httpresponse;

import org.json.JSONObject;

/**
 * Http 请求返回码
 *
 * @author FengTao
 * @date 2018/1/19.
 */
public class HttpResponseObj {
    private int code;
    private String msg;
    private Object obj;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public static String generateJsonHttpResponse(int code, String msg) {
        JSONObject obj = new JSONObject();
        obj.put("code", code);
        obj.put("msg", msg);
        return obj.toString();
    }

    public HttpResponseObj(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.obj = null;
    }

    public HttpResponseObj(int code, String msg, Object obj) {
        this.code = code;
        this.msg = msg;
        this.obj = obj;
    }
}
