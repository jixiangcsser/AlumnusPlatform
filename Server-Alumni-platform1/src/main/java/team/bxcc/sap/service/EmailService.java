package team.bxcc.sap.service;

/**
 * @Author: Ma Mengnan
 * @Description: 发送邮件接口类
 * @Date: Created on 19:02 2018/2/6.
 */
public interface EmailService {
    /**
     * 发送激活邮件
     */
    void sendActivedEmail(String user_name, String email,String UserId);

    /**
     * 发送忘记密码验证码邮件
     */
    void sendCodeEmail(String user_name);

    /**
     * 验证忘记密码
     */
    boolean verifyCodeEmail(String user_name, String code);
}
