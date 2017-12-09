package com.derek.stick.quartz.job;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author derek.wu
 * @date 2017-12-09
 * @since v1.0.0
 */
@DisallowConcurrentExecution
public class StickExampleJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

    }
}
