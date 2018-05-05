package team.bxcc.sap.model;

/**
 * 账户密码 model类
 *
 * @author FengTao
 * @date 2018/1/19.
 */
public class AccountModel {

    /**
     * 用户名
     */
    private String user_name;

    /**
     * 用户密码
     */
    private String password;

    public AccountModel() {
        this.user_name = null;
        this.password = null;
    }

    public AccountModel(String user_name, String password) {
        this.user_name = user_name;
        this.password = password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
