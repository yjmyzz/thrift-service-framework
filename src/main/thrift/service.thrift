namespace java thrift.com.cnblogs.yjmyzz.thrift.service
  
service HealthService{
    string ping()
}

service HelloService{
    string hello(1:string msg)
}