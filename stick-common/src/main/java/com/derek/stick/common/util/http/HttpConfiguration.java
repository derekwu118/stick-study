package com.derek.stick.common.util.http;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author derek.wu
 * @date 2018-11-15
 * @since v1.0.0
 */
public class HttpConfiguration implements Serializable {

    /**
     * 连接超时时间，为0表示没有超时时间
     */
    private int      connectTimeout = 0;
    /**
     * 读超时时间，为0表示没有超时时间
     */
    private int      readTimeout    = 0;
    /**
     * 写超时时间，为0表示没有超时时间
     */
    private int      writeTimeout   = 0;
    /**
     * 时间单位
     */
    private TimeUnit timeUnitType   = TimeUnit.SECONDS;

    public HttpConfiguration() {
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }

    public int getWriteTimeout() {
        return writeTimeout;
    }

    public void setWriteTimeout(int writeTimeout) {
        this.writeTimeout = writeTimeout;
    }

    public TimeUnit getTimeUnitType() {
        return timeUnitType;
    }

    public void setTimeUnitType(TimeUnit timeUnitType) {
        this.timeUnitType = timeUnitType;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.DEFAULT_STYLE);
    }
}
