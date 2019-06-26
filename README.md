# ShortenURL
将长链接换成短链接

> 原项目地址 https://github.com/yorkLiu/awesome-java

## 原理
 计算`长链接`的 `hashcode`,并将此`hascode`做为一个`key`与长链接对应, 存储在`Redis`中
  ```
  https://www.imyong.top ==> hascode d28e4411
  key: d28e4411, value: https://www.imyong.top (in redis中)
  short url: https://localhost:8080/t/d28e4411
  ```
  
  当我们访问生成的短链接时 https://localhost:8080/t/d28e4411 后台将 `d28e4411` 取出来做为`key`到`Redis`中去查找相应的value ( 也就是长链接), 取出之后返回给前端( 这里也可以直接redirect到这个长链接)
  
  **长链接 转成 短链接 逻辑**
  ```                                           
  +--------+                     +--------+                          +-----------------+
  |        |                     |        |                          |                 |
  |  Long  |       hash          |        | Store Key to Redis       |                 |
  |  URL   |------------------>  |   Key  | ------------------->     |      Redis      |
  |        |                     |        |                          |                 |
  +--------+                     +--------+                          +-----------------+ 

 ```
 
 **短链接 变回 长链接**
 ```
 
  +-----------+                                                          +-----------------+
  |           |                  /------------\     Using the Key        |                 |
  |   Short   |  Get the Key    /  BackEnd     \ to get the Long Url     |                 |
  |    URL    | -------------> (    Get the    ) --------------------->  |      Redis      |
  |           |                 \     Key     /  <---------------------  |                 |
  +-----------+                  \___________/       Return Long URL     +-----------------+
                                        |
                                        |
                                        |
                                        |
                                        V
                                +-------------+
                                |             |
                                |  Redirect   |
                                |     To      |
                                |   Long URL  |
                                +-------------+
 ```
 
 ## How to Run
 ```
 sprint-boot:run
 ```
 
 The visit https://localhost:8080 即可
 
 ## 说明
 * 本程序依赖了 [swagger-ui-layer](https://github.com/caspar-chen/swagger-ui-layer), 运行前需要安装此jar包
 
 ## 效果
 
 ![](https://raw.githubusercontent.com/gaohanghang/images/master/img20190626234123.png)
 
 ![](https://raw.githubusercontent.com/gaohanghang/images/master/img20190626234239.png)
 
 ![](https://raw.githubusercontent.com/gaohanghang/images/master/img20190626234408.png)
 
