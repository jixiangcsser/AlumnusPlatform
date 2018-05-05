package team.bxcc.sap.domain.redis;

/**
 * 阿里云oss token类
 *
 * @author FengTao
 * @date 2018/1/19.
 */
public class AliToken {
    private String AccessKeyId;
    private String AccessKeySecret;
    private String SecurityToken;

    public AliToken() {
        AccessKeyId = "";
        AccessKeySecret = "";
        SecurityToken = "";
    }

    public AliToken(String accessKeyId, String accessKeySecret, String securityToken) {
        AccessKeyId = accessKeyId;
        AccessKeySecret = accessKeySecret;
        SecurityToken = securityToken;
    }

    public String getAccessKeyId() {
        return AccessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        AccessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return AccessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        AccessKeySecret = accessKeySecret;
    }

    public String getSecurityToken() {
        return SecurityToken;
    }

    public void setSecurityToken(String securityToken) {
        SecurityToken = securityToken;
    }
}
