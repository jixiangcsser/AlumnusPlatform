package team.bxcc.sap.service;

/**
 * Token 接口类
 *
 * @author FengTao
 * @date 2018/1/19.
 */
public interface TokenService {
    String generate_AccessToken(String hash_alg, String typ, String user_name, String user_id);

    String generate_Sha1(String b64obj);

    boolean check_AccessToken(String access_token);
}
