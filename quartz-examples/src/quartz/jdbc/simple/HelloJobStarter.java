package quartz.jdbc.simple;

import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;

public class HelloJobStarter {

    public static void main(String[] args) throws Exception {

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();

        try {
            Thread.sleep(60000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduler.shutdown();
    }
}
