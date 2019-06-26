package org.hackerandpainter.repository;

/**
 * Created by yongliu on 7/11/18.
 */
public interface ShortUrlRepository {

  public void add(String key, String value);

  public String get(String key);
}
