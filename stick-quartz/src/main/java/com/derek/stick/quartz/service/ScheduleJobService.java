package com.derek.stick.quartz.service;

import com.derek.stick.quartz.entity.SchedulerEntity;

/**
 * 调度service
 * 
 * @author derek.wu
 * @date 2017-12-09
 * @since v1.0.0
 */
public interface ScheduleJobService {

    /**
     * 添加一个job
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
    Boolean addJob(SchedulerEntity entity);

    /**
     * 修改cron job的cron表达式
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
    Boolean modifyJobCron(SchedulerEntity entity);

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
    Boolean removeJob(SchedulerEntity entity);

    /**
     * 开启所有的job
     * 
     * @return java.lang.Boolean
     * @since v1.0.0
     * 
     * <PRE>
     * author: derek.wu
     * Date: 2017-12-09
     * </PRE>
     */
    Boolean startAllJobs();

    /**
     * 停止所有的job
     * 
     * @return java.lang.Boolean
     * @since v1.0.0
     * 
     * <PRE>
     * author: derek.wu
     * Date: 2017-12-09
     * </PRE>
     */
    Boolean shutdownAllJobs();

    /**
     * 检查job是否存在
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
    Boolean checkJobExists(SchedulerEntity entity);
}
