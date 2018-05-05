package team.bxcc.sap.service;

import com.aliyuncs.exceptions.ClientException;
import team.bxcc.sap.domain.redis.AliToken;

/**
 * AliToken 接口类
 *
 * @author FengTao
 * @date 2018/2/16.
 */
public interface AliTokenService {
    AliToken get_token() throws ClientException;
}
