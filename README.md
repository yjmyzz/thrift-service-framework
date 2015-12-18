# thrift-service-framework 
基于facebook thrift开源项目的服务框架,可同时供:后台服务相互以rpc方式调用，android/ios http方式调用，html5移动应用直接js调用

###支持rpc调用

支持常规的tcp/ip协议的rpc调用

###支持http协议的servlet调用

1、 支持以servlet方式嵌入web容器(tomcat/weblogic/jboss之类)运行  

2、 也可以直接用嵌入式jetty直接从jar包运行

###支持javascript调用

支持js直接调用,post的json格式为:  

以下格式无需手动拼写，thrift生成的js客户端会自动封装及解析 
 
```javascript
[1,"hello",1,0,{"1":{"str":"jimmy"}}]
```

返回结果以json格式返回:  

```javascript
[1,"hello",2,0,{"0":{"str":"hello,jimmy"}}]
```

###部署方式  
本框架支持以下二种部署方式：  

1、 jetty嵌入式模式,mvn package将在target目录下生成可直接运行的thrift-service-framework.jar, 然后java -jar thrift-service-framework.jar  

2、 将pom.xml中的\<packaging\>jar\</packaging\>中的jar改成war,同时注释掉plug中的maven-shade-plugin，然后mvn package 生成war包,可部署到任何兼容servlet 2.5+的web容器    

注：方式1下，默认http端口为8080，如需修改，可在启动时指定端口，例如：java -jar thrift-service-framework.jar -port=9090 , rpc端口在src/main/resources/spring-thrift.xml中修改

###测试运行  

1、 js调用直接浏览http://localhost:8080/thrift-service-framework/ ,点击页面的call thrift按钮,即可测试js方式直接调用  

2、 src/test/java/com/cnblogs/yjmyzz/thrift/proxy/ThriftServiceClientTest.java 里提供了rpc及http方式调用的测试用例  


---

使用过程中如有任何问题请联系 [菩提树下的杨过](http://yjmyzz.cnblogs.com)