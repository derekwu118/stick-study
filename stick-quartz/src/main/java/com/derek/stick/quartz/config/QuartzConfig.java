package com.derek.stick.quartz.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @author derek.wu
 * @date 2017-12-09
 * @since v1.0.0
 */
@Configuration
public class QuartzConfig {

    @Value("${org.quartz.scheduler.instanceName:DefaultBifrostScheduler}")
    private String instanceName;
    @Value("${org.quartz.scheduler.instanceId:AUTO}")
    private String instanceId;
    @Value("${org.quartz.jobStore.class:org.quartz.impl.jdbcjobstore.JobStoreTX}")
    private String jobStoreClass;
    @Value("${org.quartz.jobStore.driverDelegateClass:org.quartz.impl.jdbcjobstore.StdJDBCDelegate}")
    private String jobStoreDriverDelegateClass;
    @Value("${org.quartz.jobStore.tablePrefix:QRTZ_}")
    private String jobStoreTablePrefix;
    @Value("${org.quartz.jobStore.isClustered:false}")
    private String jobStoreIsClustered;
    @Value("${org.quartz.jobStore.clusterCheckinInterval:20000}")
    private String clusterCheckinInterval;
    @Value("${org.quartz.jobStore.dataSource:myDS}")
    private String jobStoreDataSource;
    /**
     * 使用自定义的Druid连接池
     */
    @Value("${org.quartz.dataSource.myDS.connectionProvider.class}")
    private String dsConnectionProviderClass;
    @Value("${org.quartz.dataSource.myDS.driver:com.mysql.jdbc.Driver}")
    private String dsDriver;
    @Value("${org.quartz.dataSource.myDS.URL}")
    private String dsUrl;
    @Value("${org.quartz.dataSource.myDS.user}")
    private String dsUser;
    @Value("${org.quartz.dataSource.myDS.password}")
    private String dsPassword;
    @Value("${org.quartz.dataSource.myDS.dsInitialSize:0}")
    private String dsInitialSize;
    @Value("${org.quartz.dataSource.myDS.maxActive:20}")
    private String dsMaxActive;
    @Value("${org.quartz.threadPool.class:org.quartz.simpl.SimpleThreadPool}")
    private String threadPoolClass;
    @Value("${org.quartz.threadPool.threadCount:20}")
    private String threadCount;
    @Value("${org.quartz.threadPool.threadPriority:5}")
    private String threadPriority;
    @Value("${org.quartz.threadPool.threadsInheritContextClassLoaderOfInitializingThread:true}")
    private String threadsInheritContextClassLoaderOfInitializingThread;

    @Bean
    public SchedulerFactoryBean getSchedulerFactoryBean() {
        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
        factoryBean.setQuartzProperties(quartzProperties());
        factoryBean.setJobFactory(stickJobFactory());
        return factoryBean;
    }

    @Bean
    public AdaptableJobFactory stickJobFactory() {
        return new StickJobFactory();
    }

    private Properties quartzProperties() {
        Properties prop = new Properties();
        prop.put("org.quartz.scheduler.instanceName", instanceName);
        prop.put("org.quartz.scheduler.instanceId", instanceId);
        prop.put("org.quartz.jobStore.class", jobStoreClass);
        prop.put("org.quartz.jobStore.driverDelegateClass", jobStoreDriverDelegateClass);
        prop.put("org.quartz.jobStore.tablePrefix", jobStoreTablePrefix);
        prop.put("org.quartz.jobStore.isClustered", jobStoreIsClustered);
        prop.put("org.quartz.jobStore.clusterCheckinInterval", clusterCheckinInterval);
        prop.put("org.quartz.jobStore.dataSource", jobStoreDataSource);
        // db
        prop.put("org.quartz.dataSource.myDS.connectionProvider.class", dsConnectionProviderClass);
        prop.put("org.quartz.dataSource.myDS.driver", dsDriver);
        prop.put("org.quartz.dataSource.myDS.URL", dsUrl);
        prop.put("org.quartz.dataSource.myDS.user", dsUser);
        prop.put("org.quartz.dataSource.myDS.password", dsPassword);
        prop.put("org.quartz.dataSource.myDS.initialSize", dsInitialSize);
        prop.put("org.quartz.dataSource.myDS.maxActive", dsMaxActive);

        prop.put("org.quartz.threadPool.class", threadPoolClass);
        prop.put("org.quartz.threadPool.threadCount", threadCount);
        prop.put("org.quartz.threadPool.threadPriority", threadPriority);
        prop.put("org.quartz.threadPool.threadsInheritContextClassLoaderOfInitializingThread",
                 threadsInheritContextClassLoaderOfInitializingThread);
        return prop;
    }
}
