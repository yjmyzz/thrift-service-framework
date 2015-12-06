package com.cnblogs.yjmyzz.thrift.main;

public class EmbededTomcat {

//    private final Logger log = LoggerFactory.getLogger(getClass());
//    private Tomcat tomcat = new Tomcat();
//    private int port;
//
//    public EmbededTomcat(int port) {
//        this.port = port;
//    }
//
//    public void start() throws Exception {
//        String projectPath = new File("").getAbsolutePath();
//        tomcat.setPort(port);
//        try {
//            tomcat.addWebapp("", projectPath + "/webapp");
//        } catch (ServletException e) {
//            e.printStackTrace();
//            log.error(e.getMessage());
//            throw e;
//        }
//        try {
//            tomcat.start();
//        } catch (LifecycleException e) {
//            e.printStackTrace();
//            log.error(e.getMessage());
//            throw e;
//        }
//        log.info("Tomcat started.");
//    }
//
//    public void stop() throws Exception {
//        try {
//            tomcat.stop();
//        } catch (LifecycleException ex) {
//            ex.printStackTrace();
//            log.error(ex.getMessage());
//            throw ex;
//        }
//        log.info("Tomcat stopped");
//    }
//
//    public void setPort(int port) {
//        this.port = port;
//    }
//
//    public int getPort() {
//        return this.port;
//    }
}
