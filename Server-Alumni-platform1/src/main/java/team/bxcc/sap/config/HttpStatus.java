package team.bxcc.sap.config;

/**
 * Http 状态码
 *
 * @author FengTao
 * @date 2018/1/19.
 */
public class HttpStatus {
    /**
     * 成功
     */
    public static final int OK = 200;

    /**
     * 错误的参数格式
     */
    public static final int WRONG_FORMAT_PARAMETER = 400;

    /**
     * 数据库操作问题
     */
    public static final int DATABASE_EXCEPTION = 401;

    /**
     * token非法
     */
    public static final int ERROR_TOKEN = 402;

    /**
     * DuplicateKeyException
     */
    public static final int DuplicateKeyException = 403;

    /**
     * 用户不存在
     */
    public static final int USERNOTEXIST = 404;

    /**
     * 账户未激活
     */
    public static final int NOT_ACTIVED = 405;

    /**
     * 未处理异常
     */
    public static final int UNEXPECTED = 891;

    /**
     * 测试
     */
    public static final int TEST = 800;
}
