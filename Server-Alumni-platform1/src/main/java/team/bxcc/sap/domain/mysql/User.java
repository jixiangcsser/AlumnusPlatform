package team.bxcc.sap.domain.mysql;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 用户账户实体类
 *
 * @author FengTao
 * @date 2018/1/19.
 */
public class User implements Serializable {

    private static final long serialVersionUID = -1L;
    public User(){}
    public User(String user_id) {
        this.id=user_id;
    }

    /**
     * 用户编号
     */
    private String id;

    /**
     * 用户名
     */
    private String user_name;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户手机号
     */
    private String phone;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户创建时间戳
     */
    private Timestamp timestamp;

    /**
     * 激活标志位 ‘0’未激活  ‘1’激活
     */
    private String actived;
    /**
     * 设置headUrlflag,头像的标志。
     */
    private String headUrlFlag;

    public String getHeadUrlFlag() {
        return headUrlFlag;
    }

    public void setHeadUrlFlag(String headUrlFlag) {
        this.headUrlFlag = headUrlFlag;
    }





    public String getActived() {
        return this.actived;
    }

    public void setActived(String actived) {
        this.actived = actived;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName=" + user_name +
                ", password=" + password +
                '}';
    }
}