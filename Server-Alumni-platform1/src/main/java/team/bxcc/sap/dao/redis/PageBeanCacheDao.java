package team.bxcc.sap.dao.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import team.bxcc.sap.domain.redis.AliToken;
import team.bxcc.sap.forum.model.PageBean;
import team.bxcc.sap.forum.model.Post;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * 暂时未启用！
 */
@Component
public class PageBeanCacheDao {
    @Resource
    private RedisTemplate<String, PageBean<Post> > redisTemplate;

    public void setCacheValue(int Curpage,String ReadType ,PageBean<Post> PageBean) {
        String key=String.valueOf(Curpage)+ReadType;
        try {
            redisTemplate.opsForValue().set(key,PageBean);//向redis里存入数据和设置缓存时间

        }catch (Exception e){
            System.out.println(e);
        }

        System.out.println("卧槽");
    }

    public PageBean<Post> getCacheValue(int Curpage,String ReadType) {
        String key=String.valueOf(Curpage)+ReadType;
        if (redisTemplate.opsForValue().get(key)!=null) {

            return redisTemplate.opsForValue().get(key);
        }
        return null;
    }
}
