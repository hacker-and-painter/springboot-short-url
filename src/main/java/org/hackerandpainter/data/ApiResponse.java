package org.hackerandpainter.data;

import com.thoughtworks.xstream.annotations.XStreamAlias;

//import javax.xml.bind.annotation.XmlRootElement;
//import javax.xml.bind.annotation.XmlTransient;

/**
 * Created by yongliu on 7/11/18.
 */
//@XmlRootElement
@XStreamAlias("apiResponse")
public class ApiResponse {
  public static final int ERROR=1;
  public static final int WARNING=2;
  public static final int INFO=3;
  public static final int OK=4;
  public static final int TOO_BUSY=5;

  //@XmlTransient
  private int code;

  private String type;

  private String message;


  public ApiResponse(int code, String message){
    this.code = code;
    this.message = message;
    switch (code){
      case ERROR:
        setType("ERROR");
        break;
      case WARNING:
        setType("WARNING");
        break;
      case INFO:
        setType("INFO");
        break;
      case OK:
        setType("OK");
        break;
      case TOO_BUSY:
        setType("TOO BUSY");
        break;
    }
  }


  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
