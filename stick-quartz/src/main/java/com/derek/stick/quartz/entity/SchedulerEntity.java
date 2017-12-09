package com.derek.stick.quartz.entity;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.quartz.Job;

/**
 * @author derek.wu
 * @date 2017-12-09
 * @since v1.0.0
 */
public class SchedulerEntity implements Serializable {

    private String               jobName;
    private String               jobGroupName;
    private String               triggerName;
    private String               triggerGroupName;
    private Class<? extends Job> jobClazz;
    private String               cron;

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroupName() {
        return jobGroupName;
    }

    public void setJobGroupName(String jobGroupName) {
        this.jobGroupName = jobGroupName;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getTriggerGroupName() {
        return triggerGroupName;
    }

    public void setTriggerGroupName(String triggerGroupName) {
        this.triggerGroupName = triggerGroupName;
    }

    public Class<? extends Job> getJobClazz() {
        return jobClazz;
    }

    public void setJobClazz(Class<? extends Job> jobClazz) {
        this.jobClazz = jobClazz;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.DEFAULT_STYLE);
    }
}
