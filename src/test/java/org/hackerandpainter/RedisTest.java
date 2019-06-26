package org.hackerandpainter;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by yongliu on 7/12/18.
 */
public class RedisTest extends BaseTest {

  @Autowired
  private RedisTemplate redisTemplate;


  @Test
  public void test1(){

    redisTemplate.boundListOps("a").leftPush("0, 1, 2, 3");
    System.out.println(redisTemplate.keys("*"));
  }

}
