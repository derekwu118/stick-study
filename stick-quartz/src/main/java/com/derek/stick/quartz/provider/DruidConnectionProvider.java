package com.derek.stick.quartz.provider;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.quartz.utils.ConnectionProvider;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @author derek.wu
 * @date 2017-12-09
 * @since v1.0.0
 */
public class DruidConnectionProvider implements ConnectionProvider {

    private DruidDataSource dataSource;

    private String          driver;

    private String          URL;

    private String          user;

    private String          password;
    /**
     * 初始化时建立物理连接的个数。初始化发生在显示调用init方法，或者第一次getConnection时。缺省值：0
     */
    private int             initialSize                               = 0;
    /**
     * 最大连接池数量。缺省值：8
     */
    private int             maxActive                                 = 8;
    /**
     * 获取连接时最大等待时间，单位毫秒。配置了maxWait之后，缺省启用公平锁，并发效率会有所下降，如果需要可以通过配置useUnfairLock属性为true使用非公平锁。
     */
    private Long            maxWait;
    /**
     * 有两个含义：
     * 1) Destroy线程会检测连接的间隔时间，如果连接空闲时间大于等于minEvictableIdleTimeMillis则关闭物理连接。
     * 2) testWhileIdle的判断依据，详细看testWhileIdle属性的说明
     * 缺省值：1min
     */
    private long            timeBetweenEvictionRunsMillis             = 60000;
    /**
     * 连接保持空闲而不被驱逐的最小时间
     */
    private long            minEvictableIdleTimeMillis                = 300000;
    /**
     * 用来检测连接是否有效的sql，要求是一个查询语句，常用select 'x'。
     * 如果validationQuery为null，testOnBorrow、testOnReturn、testWhileIdle都不会起作用。
     */
    private String          validationQuery                           = "SELECT 1";
    /**
     * 建议配置为true，不影响性能，并且保证安全性。申请连接的时候检测，
     * 如果空闲时间大于timeBetweenEvictionRunsMillis，执行validationQuery检测连接是否有效。
     */
    private boolean         testWhileIdle                             = true;
    /**
     * 申请连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能。
     */
    private boolean         testOnBorrow                              = false;
    /**
     * 归还连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能。
     */
    private boolean         testOnReturn                              = false;
    /**
     * 是否缓存preparedStatement，也就是PSCache。PSCache对支持游标的数据库性能提升巨大，比如说oracle。在mysql下建议关闭。缺失值：false
     */
    private boolean         poolPreparedStatements                    = false;
    /**
     * 要启用PSCache，必须配置大于0，当大于0时，poolPreparedStatements自动触发修改为true。
     * 在Druid中，不会存在Oracle下PSCache占用内存过多的问题，可以把这个数值配置大一些，比如说100
     */
    private int             maxPoolPreparedStatementPerConnectionSize = 0;
    /**
     * 属性类型是字符串，通过别名的方式配置扩展插件，常用的插件有：
     * 监控统计用的filter:stat
     * 日志用的filter:log4j
     * 防御sql注入的filter:wall
     */
    private String          filters                                   = "config,stat";
    /**
     *
     */
    private String          connectionProperties                      = "config.decrypt=false;druid.stat.mergeSql=true;druid.stat.slowSqlMills=5000";

    @Override
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    @Override
    public void shutdown() throws SQLException {
        dataSource.close();
    }

    @Override
    public void initialize() throws SQLException {
        if (URL == null) {
            throw new SQLException("DBPool could not be created: DB URL cannot be null.");
        }
        if (driver == null) {
            throw new SQLException("DBPool could not be created: DB driver cannot be null.");
        }
        if (maxActive <= 0) {
            throw new SQLException("DBPool could not be created: Max active must be greater than zero. maxActive: "
                                   + maxActive);
        }
        dataSource = new DruidDataSource();
        try {
            dataSource.setDriverClassName(driver);
        } catch (Exception e) {
            throw new SQLException(String.format("set dataSource driver error. driver: %s", driver), e);
        }
        dataSource.setUrl(URL);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        dataSource.setInitialSize(initialSize);
        dataSource.setMaxActive(maxActive);
        dataSource.setMinIdle(maxActive);
        if (maxWait != null) {
            dataSource.setMaxWait(maxWait);
        }
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setTestWhileIdle(testWhileIdle);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestOnReturn(testOnReturn);
        dataSource.setPoolPreparedStatements(poolPreparedStatements);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        dataSource.setFilters(filters);
        try {
            if (StringUtils.isNotBlank(connectionProperties)) {
                Properties properties = new Properties();
                String[] connPropArr = connectionProperties.split(";");
                if (connPropArr.length > 0) {
                    for (String connProp : connPropArr) {
                        String[] keyValue = connProp.split("=");
                        if (keyValue.length == 2 && StringUtils.isNotBlank(keyValue[0])
                            && StringUtils.isNotBlank(keyValue[1])) {
                            properties.put(keyValue[0], keyValue[1]);
                        }
                    }
                }
                dataSource.setConnectProperties(properties);
            }
        } catch (Exception e) {
            throw new SQLException(String.format("parse & set connection.properties error. connectionProperties: %s",
                                                 connectionProperties),
                                   e);
        }
    }
}
