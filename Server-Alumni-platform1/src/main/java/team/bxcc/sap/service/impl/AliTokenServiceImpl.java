package team.bxcc.sap.service.impl;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sts.model.v20150401.AssumeRoleRequest;
import com.aliyuncs.sts.model.v20150401.AssumeRoleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.bxcc.sap.dao.redis.AliTokenDao;
import team.bxcc.sap.service.AliTokenService;
import team.bxcc.sap.domain.redis.AliToken;

/**
 * AliToken 实现类
 *
 * @author FengTao
 * @date 2018/1/19.
 */
@Service
public class AliTokenServiceImpl implements AliTokenService {

    @Autowired
    private AliTokenDao aliTokenDao;

    @Override
    public AliToken get_token() throws ClientException {

        if (aliTokenDao.getCacheValue() == null) {
            System.out.println("准备进入");
            String endpoint = "sts.aliyuncs.com";
            String accessKeyId = "LTAIVz7TwaSO7otx";
            String accessKeySecret = "RzdMSu84VZqj1PQIRUItDoCaaWj6Iw";
            String roleArn = "acs:ram::1361416689521017:role/fengtao";
            String roleSessionName = "session-name";

            // Init ACS Client
            DefaultProfile.addEndpoint("", "", "Sts", endpoint);
            IClientProfile profile = DefaultProfile.getProfile("", accessKeyId, accessKeySecret);
            DefaultAcsClient client = new DefaultAcsClient(profile);
            final AssumeRoleRequest request = new AssumeRoleRequest();
            request.setMethod(MethodType.POST);
            request.setRoleArn(roleArn);
            request.setRoleSessionName(roleSessionName);
            request.setDurationSeconds(3600L);
            final AssumeRoleResponse response = client.getAcsResponse(request);
            /*设置aliToken*/
            System.out.println("进入");
            aliTokenDao.setCacheValue(new AliToken(response.getCredentials().getAccessKeyId(), response.getCredentials().getAccessKeySecret(), response.getCredentials().getSecurityToken()));
            System.out.println("获取");
            return new AliToken(response.getCredentials().getAccessKeyId(), response.getCredentials().getAccessKeySecret(), response.getCredentials().getSecurityToken());

        }
        /*如果已经保存了aliToken就直接返回*/
        return aliTokenDao.getCacheValue();
    }
}
