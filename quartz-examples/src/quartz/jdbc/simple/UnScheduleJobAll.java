package quartz.jdbc.simple;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;

public class UnScheduleJobAll {

    public static void main(String[] args) throws SchedulerException {

        Scheduler inScheduler = StdSchedulerFactory.getDefaultScheduler();

        for (String group : inScheduler.getTriggerGroupNames()) {
            GroupMatcher<TriggerKey> matcher = GroupMatcher.triggerGroupEquals(group);
            for (TriggerKey triggerKey : inScheduler.getTriggerKeys(matcher)) {

                inScheduler.unscheduleJob(triggerKey);
                System.out.println("Triggerを削除します:" + triggerKey);
            }
        }
    }
}
