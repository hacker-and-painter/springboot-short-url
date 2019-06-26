package org.hackerandpainter.exception;

/**
 * Created by yongliu on 7/11/18.
 */
public class BadRequestException extends ApiException {
  public BadRequestException(int code, String msg) {
    super(code, msg);
  }
}
