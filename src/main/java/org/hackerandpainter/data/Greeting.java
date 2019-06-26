package org.hackerandpainter.data;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import io.swagger.annotations.ApiModelProperty;

//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by yongliu on 7/11/18.
 */
//@XmlRootElement(name = "Greeting")
@XStreamAlias("Greeting")
public class Greeting {

  //@XmlElement(name = "timestamp")
  @ApiModelProperty(name = "timestamp")
  private String timestamp;

  //@XmlElement(name = "content")
  @ApiModelProperty(name = "content")
  private String content;

  public Greeting(String content){
    timestamp = String.format("%s", new Date().getTime());
    this.content = content;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
