package org.hackerandpainter.repository;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by yongliu on 7/11/18.
 */

@Repository
public class ShortUrlRepositoryImpl implements ShortUrlRepository {

  @Resource(name = "redisTemplate")
  private RedisTemplate<String, Object> redisTemplate;

  @Override
  public void add(String key, String value) {
    redisTemplate.boundValueOps(key).set(value);
  }

  @Override
  public String get(String key) {
    Object obj = redisTemplate.boundValueOps(key).get();
    if(obj != null){
      return obj.toString();
    }
    return null;
  }
}
