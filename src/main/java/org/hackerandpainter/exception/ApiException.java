package org.hackerandpainter.exception;

/**
 * Created by yongliu on 7/11/18.
 */
public class ApiException extends Exception {

  protected int code;

  public ApiException(int code, String msg){
    super(msg);
    this.code = code;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }
}
