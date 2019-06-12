package vip.wush.idempotence.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: RedisLock
 * @Description: TODO
 * @Author: wush
 * @Date: 2019/6/12 11:56
 */

@Component
public class RedisLock {

    private static final Logger logger = LoggerFactory.getLogger(RedisLock.class);

    @Autowired
    private StringRedisTemplate template;

    public synchronized boolean tryLock(String key, String value) {

        boolean isSuccess = template.opsForValue().setIfAbsent(key, value);

        if(isSuccess){
            return true;
        }
        return false;
    }

    public void expire(String key, int expire){
        template.expire(key, expire, TimeUnit.MILLISECONDS);
    }

    public void releaseLock(String key, String value) {
//        expire(key, 1);
        template.delete(key);
    }

}
