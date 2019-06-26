package org.hackerandpainter.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.lang.Nullable;

import java.nio.charset.Charset;

/**
 * Using alibaba "fastjson" to  implementation the redis serializer
 */
public class FastJson2JsonRedisSerializer<T> implements RedisSerializer<T> {
  private static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

  private Class<T> clazz = null;

  public FastJson2JsonRedisSerializer(Class<T> clazz) {
    super();
    this.clazz = clazz;
  }

  @Override
  public byte[] serialize(@Nullable T t) throws SerializationException {
    if (t == null) {
      return new byte[0];
    }
    return JSON.toJSONString(t, SerializerFeature.WriteClassName).getBytes(DEFAULT_CHARSET);
  }

  @Override
  public T deserialize(@Nullable byte[] bytes) throws SerializationException {
    if (bytes == null || bytes.length == 0) {
      return null;
    }
    String s = new String(bytes, DEFAULT_CHARSET);
    return (T) JSON.parseObject(s, clazz);
  }
}
