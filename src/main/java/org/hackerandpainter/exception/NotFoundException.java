package org.hackerandpainter.exception;

/**
 * Created by yongliu on 7/12/18.
 */
public class NotFoundException extends ApiException {
  public NotFoundException(int code, String msg) {
    super(405, msg);
    this.code = code;

  }
}
