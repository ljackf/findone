package com.ljf.task;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class AutoClock implements Job{

    public static void main(String[] args) throws SchedulerException {
        AutoClock autoClock = new AutoClock();
        autoClock.clock();
    }

    public void clock() throws SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        JobDetail jobDetail = newJob(AutoClock.class).withIdentity("job_clock", "group_clock").build();
        CronTrigger trigger = newTrigger().withIdentity("trigger_clock", "group_clock")
                .withSchedule(cronSchedule("0 0 9,18 * * ?")).build();
        scheduler.scheduleJob(jobDetail, trigger);
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        HttpUtil
    }
}
