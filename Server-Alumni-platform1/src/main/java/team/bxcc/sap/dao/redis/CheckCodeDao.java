package team.bxcc.sap.dao.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import team.bxcc.sap.domain.redis.Code;

import javax.annotation.Resource;

@Component
public class CheckCodeDao {

    @Resource
    private RedisTemplate<Object, Object> redisTemplate;


    public void setCacheValue(String key, Code value) {
        redisTemplate.opsForHash().put("check_code", key, value);
    }

    public Code getCacheValue(String key) {
        return (Code) redisTemplate.opsForHash().get("check_code", key);
    }

    public boolean hasCacheValue(String key) {
        return redisTemplate.opsForHash().hasKey("check_code", key);
    }
}
