package team.bxcc.sap.service.impl;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import team.bxcc.sap.config.ConStants;
import team.bxcc.sap.dao.mysql.UserDao;
import team.bxcc.sap.dao.redis.CheckCodeDao;
import team.bxcc.sap.domain.mysql.User;
import team.bxcc.sap.domain.redis.Code;
import team.bxcc.sap.service.EmailService;

import java.util.Date;
import java.util.Random;

/**
 * @Author: Ma Mengnan
 * @Description: 发送邮件实现类
 * @Date: Created on 19:02 2018/2/6.
 */

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private UserDao userDao;

    @Autowired
    private CheckCodeDao checkCodeDao;

    @Value("${spring.mail.username}")
    private String username;

    private void send(String html, String email, String subject) {
        try {
            /**
             * 如下就是发送邮件的关键之处。
             */
            MimeMessage msg = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(msg, true, "utf-8");
            helper.setFrom(username);//发送邮箱地址
            helper.setTo(email);//接受邮件的地址！
            helper.setSubject(subject);
            helper.setText(html, true); //测试内容
            javaMailSender.send(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @Async
    public void sendActivedEmail(String user_name, String email,String UserId) {

        this.send("亲爱的用户" + user_name + "，请猛戳下面激活您的账户 <a href='" + ConStants.ACTIVED_EMAIL_URL + "?user_name=" + user_name + "'>点此激活</a><br/>" +
                "如果点击后无效或者无法访问，请手动复制链接进行访问 " + ConStants.ACTIVED_EMAIL_URL + "?user_Id=" + UserId
                + "<br/>软院校友平台期待你的加入！", email, "软院校友平台账户激活");
    }

    @Override
    @Async
    public void sendCodeEmail(String user_name) {
        User user = userDao.getUserInfo(user_name);
        if (user != null) {
            String code = String.valueOf(new Random().nextInt(9000) + 1000);
            checkCodeDao.setCacheValue(user_name, new Code(code, new Date().getTime()));
            this.send("亲爱的用户" + user_name + "您的验证码为: " + code, user.getEmail(), "验证码");
        }
    }

    @Override
    public boolean verifyCodeEmail(String user_name, String code) {
        return checkCodeDao.hasCacheValue(user_name) && checkCodeDao.getCacheValue(user_name).getCode().equals(code);
    }
}
