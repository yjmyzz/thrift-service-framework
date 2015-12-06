# thrift-service-framework 
基于facebook thrift rpc框架的服务框架,可同时供:后台服务相互以rpc方式调用，android/ios http方式调用，html5移动应用直接js调用

###支持rpc调用

支持常规的tcp/ip协议的rpc调用

###支持http协议的servlet调用

支持以servlet方式嵌入web容器(jetty/tomcat之类)运行

###支持javascript调用

支持js直接调用,返回结果以json格式返回  

```javascript

```

###部署方式
mvn package 生成war包,可部署到任何兼容servlet 2.5+的web容器,http端口及rpc端口均可在配置文件中修改  

###测试运行
本项目内嵌了tomcat及jetty maven插件,直接mvn clean package tomcat7:run 或mvn clean package jetty:run 即可启用  

1、 js调用直接浏览http://localhost:8080/thrift-service-framework/ ,点击页面的call thrift按钮,即可测试js方式直接调用  

2、 src/test/java/com/cnblogs/yjmyzz/thrift/proxy/ThriftServiceClientTest.java 里提供了rpc及http方式调用的测试用例  

---

使用过程中如有任何问题请联系:(菩提树下的杨过)[http://yjmyzz.cnblogs.com/]

