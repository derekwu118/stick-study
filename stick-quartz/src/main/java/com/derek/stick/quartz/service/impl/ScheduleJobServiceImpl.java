package com.derek.stick.quartz.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.derek.stick.common.serialize.SerializableTool;
import com.derek.stick.quartz.entity.SchedulerEntity;
import com.derek.stick.quartz.service.ScheduleJobService;
import com.derek.stick.quartz.util.ScheduleJobValidate;

/**
 * @author derek.wu
 * @date 2017-12-09
 * @since v1.0.0
 */
@Service
public class ScheduleJobServiceImpl implements ScheduleJobService {

    private static final Logger logger = LoggerFactory.getLogger(ScheduleJobServiceImpl.class);

    @Autowired
    private Scheduler           scheduler;

    /**
     * 添加job
     * 
     * @param entity
     * @return java.lang.Boolean
     * @since v1.0.0
     * 
     * <PRE>
     * author: derek.wu
     * Date: 2017-12-09
     * </PRE>
     */
    @Override
    public Boolean addJob(SchedulerEntity entity) {
        try {
            ScheduleJobValidate.validateSchedulerEntity(entity);
            JobDetail jobDetail = JobBuilder.newJob(entity.getJobClazz())
                                            .withIdentity(entity.getJobName(), entity.getJobGroupName())
                                            .build();
            TriggerBuilder<Trigger> tb = TriggerBuilder.newTrigger();
            tb.withIdentity(entity.getTriggerName(), entity.getTriggerGroupName());
            tb.startNow();
            if (StringUtils.isBlank(entity.getCron())) {
                tb.withSchedule(SimpleScheduleBuilder.simpleSchedule()
                                                     .withIntervalInSeconds(1)
                                                     .withMisfireHandlingInstructionIgnoreMisfires());
            } else {
                // misfire策略：会合并部分的misfire，正常执行下一个周期的任务
                tb.withSchedule(CronScheduleBuilder.cronSchedule(entity.getCron())
                                                   .withMisfireHandlingInstructionFireAndProceed());
            }
            Trigger trigger = tb.build();
            scheduler.scheduleJob(jobDetail, trigger);
            return true;
        } catch (Exception e) {
            logger.error("add job error. entity: {}", SerializableTool.serialize(entity), e);
            return false;
        }
    }

    /**
     * 修改cron
     * 
     * @param entity
     * @return java.lang.Boolean
     * @since v1.0.0
     * 
     * <PRE>
     * author: derek.wu
     * Date: 2017-12-09
     * </PRE>
     */
    @Override
    public Boolean modifyJobCron(SchedulerEntity entity) {
        try {
            ScheduleJobValidate.validateSchedulerEntity(entity);
            if (StringUtils.isBlank(entity.getCron())) {
                logger.warn("cron expression is blank.");
                return false;
            }
            TriggerKey triggerKey = TriggerKey.triggerKey(entity.getTriggerName(), entity.getTriggerGroupName());
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            if (trigger == null) {
                logger.error("modify job cron time error. trigger is not exist. entity: {}",
                             SerializableTool.serialize(entity));
                return false;
            }
            String oldCron = trigger.getCronExpression();
            if (!oldCron.equalsIgnoreCase(entity.getCron())) {
                TriggerBuilder<Trigger> tb = TriggerBuilder.newTrigger();
                tb.withIdentity(entity.getTriggerName(), entity.getTriggerGroupName());
                tb.startNow();
                tb.withSchedule(CronScheduleBuilder.cronSchedule(entity.getCron()));
                trigger = (CronTrigger) tb.build();
                scheduler.rescheduleJob(triggerKey, trigger);
            }
            return true;
        } catch (Exception e) {
            logger.error("modify job cron expression error. entity: {}", SerializableTool.serialize(entity), e);
            return false;
        }
    }

    /**
     * 删除job
     * 
     * @param entity
     * @return java.lang.Boolean
     * @since v1.0.0
     * 
     * <PRE>
     * author: derek.wu
     * Date: 2017-12-09
     * </PRE>
     */
    @Override
    public Boolean removeJob(SchedulerEntity entity) {
        try {
            ScheduleJobValidate.validateSchedulerEntity(entity);
            TriggerKey triggerKey = TriggerKey.triggerKey(entity.getTriggerName(), entity.getTriggerGroupName());
            scheduler.pauseTrigger(triggerKey);
            scheduler.unscheduleJob(triggerKey);
            scheduler.deleteJob(JobKey.jobKey(entity.getJobName(), entity.getJobGroupName()));
            return true;
        } catch (Exception e) {
            logger.error("remove job error. entity: {}", SerializableTool.serialize(entity), e);
            return false;
        }
    }

    @Override
    public Boolean startAllJobs() {
        try {
            scheduler.start();
            return true;
        } catch (SchedulerException e) {
            logger.error("start all jobs error.", e);
            return false;
        }
    }

    @Override
    public Boolean shutdownAllJobs() {
        try {
            if (!scheduler.isShutdown()) {
                scheduler.shutdown();
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean checkJobExists(SchedulerEntity entity) {
        TriggerKey tk = TriggerKey.triggerKey(entity.getTriggerName(), entity.getTriggerGroupName());
        try {
            return scheduler.checkExists(tk);
        } catch (SchedulerException e) {
            logger.error("check job exists failed. entity: {}", SerializableTool.serialize(entity), e);
            return false;
        }
    }
}
