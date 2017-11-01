package com.jxd.autoparts.provider;


import com.jxd.autoparts.provider.lisenter.InitContextListener;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableScheduling
//引入数据源后需要删除
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
//@EnableTransactionManagement //启用事务
@ImportResource(value={"${ConfigPath}dubbo-provider.xml"})
//@EnableJpaRepositories(basePackages="com.alicm.open.provider.persistence.inf",entityManagerFactoryRef="entityManagerFactory",transactionManagerRef="transactionManager")
@ComponentScan(basePackages={"com.jxd.autoparts.provider"})
public class AppProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppProvider.class);

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

        SpringApplication application = new SpringApplication(AppProvider.class);
        application.setRegisterShutdownHook(false);
        application.addListeners(new InitContextListener());
        application.run(args);

        System.out.println( "Hello AppProvider is run....." );

    }

}
