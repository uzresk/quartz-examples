package quartz.jdbc.simple;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob implements Job {

    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("hello " + new Date() + " :" + context.getJobDetail());

    }
}
