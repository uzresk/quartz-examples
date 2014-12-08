package quartz.jdbc.simple;

import java.util.TimeZone;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class RegistHelloJob {

    public static void main(String[] args) throws Exception {

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        JobDetail job = JobBuilder.newJob(HelloJob.class)
                .withIdentity("helloJob", "jobGroup1")
                .storeDurably()
                .build();

        CronTrigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("cronTrigger1", "triggerGroup1")
                .withSchedule(
                        CronScheduleBuilder.cronSchedule("*/5 * * * * ?")
                                .inTimeZone(TimeZone.getTimeZone("Asia/Tokyo"))).startNow().build();

        scheduler.scheduleJob(job, trigger);

        System.out.println("JOBの登録が完了しました。");
    }
}
