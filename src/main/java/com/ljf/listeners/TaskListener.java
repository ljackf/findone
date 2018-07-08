package com.ljf.listeners;

import com.ljf.task.AutoClock;
import com.ljf.task.BtcMinuteTask;
import org.apache.log4j.Logger;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class TaskListener implements ServletContextListener {
    private static final Logger logger = Logger.getLogger(TaskListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("任务监听器初始化*****");
        try {

            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            JobDetail jobDetail = newJob(BtcMinuteTask.class).withIdentity("job_clock", "group_clock").build();
            CronTrigger trigger = newTrigger().withIdentity("trigger_clock", "group_clock")
                    .withSchedule(cronSchedule("0 */1 * * * ?")).build();
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            logger.info("任务监听器初始化失败");
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
