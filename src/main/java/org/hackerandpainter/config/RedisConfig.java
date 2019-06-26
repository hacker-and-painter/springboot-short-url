package org.hackerandpainter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.StringUtils;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@ComponentScan("org.hackerandpainter.repository")
public class RedisConfig {

  @Autowired
  private RedisConfigProperties redis;

  @Bean
  public RedisSerializer fastjson2JsonRedisSerializer(){
    return new FastJson2JsonRedisSerializer<Object>(Object.class);
  }

  @Bean
  public RedisConnectionFactory  redisConnectionFactory(){
    JedisPoolConfig poolConfig = new JedisPoolConfig();
    poolConfig.setMaxIdle(redis.getMaxIdle());
    poolConfig.setMinIdle(redis.getMinIdle());
    poolConfig.setMaxWaitMillis(redis.getMaxWait());

    RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
    redisStandaloneConfiguration.setHostName(redis.getHost());
    redisStandaloneConfiguration.setPort(redis.getPort());
    redisStandaloneConfiguration.setDatabase(redis.getDatabase());
    redisStandaloneConfiguration.setPassword((redis.getPassword() != null && StringUtils.hasText(redis.getPassword()))? RedisPassword.of(redis.getPassword()): RedisPassword.none());

    JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(redisStandaloneConfiguration);

    return jedisConnectionFactory;
  }


  @Bean
  public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory, RedisSerializer fastjson2RedisSerializer){
    StringRedisTemplate redisTemplate = new StringRedisTemplate(factory);

    redisTemplate.setEnableTransactionSupport(Boolean.TRUE);

    redisTemplate.setHashValueSerializer(fastjson2RedisSerializer);
    redisTemplate.setHashKeySerializer(new StringRedisSerializer());

    redisTemplate.setKeySerializer(new StringRedisSerializer());
    redisTemplate.setValueSerializer(fastjson2RedisSerializer);

    redisTemplate.afterPropertiesSet();

    return redisTemplate;
  }


}
