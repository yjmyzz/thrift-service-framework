package com.cnblogs.yjmyzz.thrift.main;

import com.cnblogs.yjmyzz.thrift.embed.JettyWebServer;
import com.cnblogs.yjmyzz.thrift.util.FileUtil;
import com.cnblogs.yjmyzz.thrift.util.JarUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;


import java.util.HashMap;
import java.util.Map;

/**
 * {type your description }
 *
 * @since: 12/6/15.
 * @author: yangjunming
 */
public class ThriftServer {

    private static final String PORT = "port";
    private static final String WEB_DIR = "web";
    private static final String LOG_DIR = "log";
    private static final String TEMP_DIR = "temp";
    private static final String CONTEXT_PATH = "context";
    private static final String HOST = "host";
    private static final Map<String, String> param = new HashMap<>();
    private static Logger logger = LoggerFactory.getLogger(ThriftServer.class);


    public static void main(String... args) throws Exception {

        param.put(PORT, "8080");
        param.put(WEB_DIR, "web");
        param.put(LOG_DIR, "logs");
        param.put(TEMP_DIR, "temp");
        param.put(CONTEXT_PATH, "/");
        param.put(HOST, "localhost");


        for (String arg : args) {
            logger.debug(arg);
            if (!StringUtils.isEmpty(arg) && arg.contains("=")) {
                String[] t = arg.trim().split("=");
                param.put(StringUtils.trimLeadingCharacter(t[0].trim(), '-'), t[1]);
            }
        }

        initParam();

        unzipSelf();

        new ThriftServer().start();
    }


    private static void initParam() {


        String logDir = FileUtil.currentWorkDir + param.get(LOG_DIR);
        String tempDir = FileUtil.currentWorkDir + param.get(TEMP_DIR);
        String webDir = FileUtil.currentWorkDir + param.get(WEB_DIR);

        logger.debug(logDir);
        logger.debug(tempDir);
        logger.debug(webDir);

        String temp = "x.x";//占位
        FileUtil.createDirs(logDir + "/" + temp);
        FileUtil.createDirs(tempDir + "/" + temp);
        FileUtil.createDirs(webDir + "/" + temp);

        param.put(LOG_DIR, logDir);
        param.put(TEMP_DIR, tempDir);
        param.put(WEB_DIR, webDir);
    }

    private JettyWebServer server;

    public ThriftServer() {
        server = new JettyWebServer(
                Integer.parseInt(param.get(PORT).toString()),
                param.get(HOST),
                param.get(TEMP_DIR),
                param.get(WEB_DIR),
                param.get(LOG_DIR),
                param.get(CONTEXT_PATH));
    }

    public void start() throws Exception {
        server.start();
        server.join();
    }

    private static void unzipSelf() {
        //将jar自身解压

        String selfPath = FileUtil.getJarExecPath(ThriftServer.class);
        if (selfPath.endsWith(".jar")) {
            // 运行环境
            try {
                logger.info("正在将\n" + selfPath + "\n解压至\n" + param.get(WEB_DIR));
                JarUtils.unJar(selfPath, param.get(WEB_DIR));
            } catch (Exception e) {
                logger.error("解压web内容失败!", e);
            }
        } else {
            // IDE环境
            param.put(WEB_DIR, selfPath);
        }
        logger.info(selfPath);
    }
}
