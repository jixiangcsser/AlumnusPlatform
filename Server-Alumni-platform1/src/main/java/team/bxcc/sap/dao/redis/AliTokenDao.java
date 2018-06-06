package team.bxcc.sap.dao.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import team.bxcc.sap.domain.redis.AliToken;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class AliTokenDao {
    @Resource
    private RedisTemplate<String, String> redisTemplate;

    public void setCacheValue(AliToken value) {
        redisTemplate.opsForValue().set("ali_token_AccessKeyId", value.getAccessKeyId(), 3589, TimeUnit.SECONDS);
        redisTemplate.opsForValue().set("ali_token_AccessKeySecret", value.getAccessKeySecret(), 3589, TimeUnit.SECONDS);
        redisTemplate.opsForValue().set("ali_token_SecurityToken", value.getSecurityToken(), 3589, TimeUnit.SECONDS);
    }

    public AliToken getCacheValue() {

        if (redisTemplate.opsForValue().get("ali_token_AccessKeyId") != null && redisTemplate.opsForValue().get("ali_token_AccessKeySecret") != null && redisTemplate.opsForValue().get("ali_token_SecurityToken") != null) {

            return new AliToken(redisTemplate.opsForValue().get("ali_token_AccessKeyId"), redisTemplate.opsForValue().get("ali_token_AccessKeySecret"), redisTemplate.opsForValue().get("ali_token_SecurityToken"));
        }
        return null;
    }
}
