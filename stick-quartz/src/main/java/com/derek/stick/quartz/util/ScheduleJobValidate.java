package com.derek.stick.quartz.util;

import org.apache.commons.lang3.StringUtils;

import com.derek.stick.quartz.entity.SchedulerEntity;
import com.google.common.base.Preconditions;

/**
 * @author derek.wu
 * @date 2017-12-09
 * @since v1.0.0
 */
public class ScheduleJobValidate {

    public static void validateSchedulerEntity(SchedulerEntity entity) {
        Preconditions.checkNotNull(entity, "entity is null.");
        Preconditions.checkArgument(StringUtils.isBlank(entity.getJobName()), "jobName is blank.");
        Preconditions.checkArgument(StringUtils.isBlank(entity.getJobGroupName()), "jobGroupName is blank.");
        Preconditions.checkArgument(StringUtils.isBlank(entity.getTriggerName()), "triggerName is blank.");
        Preconditions.checkArgument(StringUtils.isBlank(entity.getTriggerGroupName()), "triggerGroupName is blank.");
        Preconditions.checkNotNull(entity.getJobClazz(), "jobClazz is null.");
    }
}
