package com.jxd.autoparts.consumer;


import com.jxd.autoparts.api.interfaces.IDemoService;
import com.jxd.autoparts.api.pojo.DemoPj;
import com.jxd.autoparts.common.utils.DdPwdMgUtil;
import com.jxd.autoparts.consumer.lisenter.InitContextListener;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@EnableScheduling
@SpringBootApplication
@ImportResource(value={"${ConfigPath}dubbo-consumer.xml"})
@ComponentScan(basePackages={"com.jxd.autoparts.consumer","com.jxd.autoparts.common"})
public class AppConsumer {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IDemoService demoService;


    public static void main( String[] args ) {

        //jar方式启动时 系统变量ConfigPath 必需有值
        if(StringUtils.isEmpty(System.getProperty("ConfigPath"))){
            System.setProperty("ConfigPath","classpath:");
            System.setProperty("ConfigPathNot","/");
            System.setProperty("ConfigFindPath","");
        }else{
            //System.setProperty("ConfigPathNot",System.getProperty("ConfigPath").replace("file:",""));
            //System.setProperty("ConfigFindPath",System.getProperty("user.dir")+File.separator+"config"+File.separator);
            //jar 启动时， 指定框架读取/config目录里的log4j.xml 文件
            //PropertyConfigurator.configure(System.getProperty("user.dir")+File.separator+"config"+File.separator+"log4j.properties");
        }

        // 设置公钥
        System.setProperty("publicKey", DdPwdMgUtil.DEFAULT_PUBLICKEY);


        SpringApplication application = new SpringApplication(AppConsumer.class);
        application.setRegisterShutdownHook(false);
        application.addListeners(new InitContextListener());
        application.run(args);

        System.out.println( "Hello AppConsumer is run....." );

    }

    @RequestMapping(value="/getdemo", method= RequestMethod.GET)
    public DemoPj getdemo(HttpServletRequest request)
            throws Exception {
        DemoPj pj = demoService.getDemoPj("你", "说",":","abc123");
        return pj;
    }

    @RequestMapping(value="/getdemoList",  method= RequestMethod.GET)
    public List<DemoPj> getdemoList(HttpServletRequest request)
            throws Exception {
        List<DemoPj> pjs = demoService.getDemoPjList(3);
        return pjs;
    }

    @RequestMapping(value="/testlog",  method= RequestMethod.GET)
    public void testlog()
            throws Exception {
        LOGGER.trace("======trace");
        LOGGER.debug("======debug");
        LOGGER.info("======info");
        LOGGER.warn("======warn");
        LOGGER.error("======error");

    }

}
