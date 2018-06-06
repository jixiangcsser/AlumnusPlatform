package team.bxcc.sap.config;

/**
 * 常量
 *
 * @author FengTao
 * @date 2018/1/19.
 */
public class ConStants {

    /**
     * 姓名正则
     */
    public static final String MATCH_REGULAR_EXP_NAME = "^([\\u4e00-\\u9fa5\\·]{1,10})$";

    /**
     * userinfo common 正则
     */
    public static final String MATCH_REGULAR_USERINFO_COMMON = ".{1,30}$";

    /**
     * 密码正则(弱1)
     * 8-16位数字，字母，字符其中两种
     */
    public static final String MATCH_WEAK1_REGULAR_EXP_PASSWORD = "^(?!\\d+$)(?![a-zA-Z]+$)[\\dA-Za-z]{8,16}$";

    /**
     * 密码正则(弱2)
     * 8-16位数字，字母，字符其中两种
     */
    public static final String MATCH_WEAK2_REGULAR_EXP_PASSWORD = "^(?!((?=[\\x21-\\x7e]+)[^A-Za-z0-9])+$)(?![a-zA-Z]+$)[^\\u4e00-\\u9fa5\\d]{8,16}$";

    /**
     * 密码正则(弱3)
     * 8-16位数字，字母，字符其中两种
     */
    public static final String MATCH_WEAK3_REGULAR_EXP_PASSWORD = "^(?!((?=[\\x21-\\x7e]+)[^A-Za-z0-9])+$)(?!\\d+$)[^\\u4e00-\\u9fa5a-zA-Z]{8,16}$";

    /**
     * 密码正则(中)
     * 强 8-14位    数字，字母，字符其中三种
     */
    public static final String MATCH_MID_REGULAR_EXP_PASSWORD = "^(?=.*((?=[\\x21-\\x7e]+)[^A-Za-z0-9]))(?=.*[a-zA-Z])(?=.*[0-9])[^\\u4e00-\\u9fa5]{8,13}$";

    /**
     * 密码正则(强)
     * 14-16位 数字，字母，字符其中三种
     */
    public static final String MATCH_STRONG_REGULAR_EXP_PASSWORD = "^(?=.*((?=[\\x21-\\x7e]+)[^A-Za-z0-9]))(?=.*[a-zA-Z])(?=.*[0-9])[^\\u4e00-\\u9fa5]{14,16}$";

    /**
     * 账户正则
     * 数字和字母，且长度要在6-15位之间
     */
    public static final String MATCH_REGULAR_EXP_ACCOUNT = "^[A-Za-z0-9]{6,15}$";

    /**
     * 手机号正则
     */
    public static final String MATCH_REGULAR_EXP_PHONE = "^134[0-8]\\d{7}$|^13[^4]\\d{8}$|^14[5-9]\\d{8}$|^15[^4]\\d{8}$|^16[6]\\d{8}$|^17[0-8]\\d{8}$|^18[\\d]{9}$|^19[8,9]\\d{8}$";

    /**
     * 数据库密码字段sha256-盐
     */
    public static final String PASSWORD_SHA256_SALT = "secret";

    /**
     * token有效期（毫秒）
     */
    public static final int TOKEN_EXPIRES_HOUR = 7200000;

    /**
     * actived_email url
     * http://localhost:9090/api/email
     * http://47.94.229.48:80/api/email
     */
    public static final String ACTIVED_EMAIL_URL = "http://localhost:9090/api/email";

    /**
     * actived_redirect url
     * http://sse-ustc.oss-cn-beijing.aliyuncs.com/verify
     */
    public static final String ACTIVED_REDIRECT_URL = "http://localhost:8085/verify";

    /**
     * operation的类型回复了帖子
     */
    public static final String OPERATION_REPLY="回复了您的帖子";
    /**
     * operation的类型赞了帖子
     */
    public static final String OPERATION_CLICK_LIKE="赞了您的帖子";
}
