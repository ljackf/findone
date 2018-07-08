package com.ljf.task;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class BtcMinuteTask implements Job {
    private static final Logger logger = Logger.getLogger(BtcMinuteTask.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("执行任务");
    }
}
