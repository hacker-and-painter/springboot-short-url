package org.hackerandpainter.data;

import com.thoughtworks.xstream.annotations.XStreamAlias;

//import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by yongliu on 7/11/18.
 */
//@XmlRootElement(name = "ShortURL")
@XStreamAlias("ShortURL")
public class ShortenURL {

  private String originUrl;
  private String destinationUrl;
  private String key;
  private String timestamp;

  public ShortenURL(String originUrl, String destinationUrl, String key){
    this.originUrl = originUrl;
    this.destinationUrl = destinationUrl;
    this.key = key;
    this.timestamp = String.format("%s", new Date().getTime());
  }


  public String getOriginUrl() {
    return originUrl;
  }

  public void setOriginUrl(String originUrl) {
    this.originUrl = originUrl;
  }

  public String getDestinationUrl() {
    return destinationUrl;
  }

  public void setDestinationUrl(String destinationUrl) {
    this.destinationUrl = destinationUrl;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }
}
