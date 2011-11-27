package net.teamsparq.animation.concurrency.swing;

import net.teamsparq.animation.concurrency.future.ResultGetter;
import net.teamsparq.animation.concurrency.future.TaskSubmitter;
import net.teamsparq.animation.concurrency.future.ThreadPoolComputation;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.concurrent.*;

import static junit.framework.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: Dragos
 * Date: 27/11/11
 * Time: 11:38
 * To change this template use File | Settings | File Templates.
 */
public class ResultGetterTest {

    private static final Logger LOGGER = Logger.getLogger(ResultGetterTest.class);


    @Test
    public void testResultGetterType() throws Exception{
        BasicConfigurator.configure();            // log4j configuration
        ExecutorService executorService = null;
        TaskSubmitter taskSubmitter = null;
        ThreadPoolComputation threadPoolComputation = null;
        ResultGetter<Long> resultGetter = null;
        FutureTask<Long> future = new FutureTask<Long>(new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                Long sum = new Long(0L);
                for (Long i = 0L; i < 1000L; i++) {
                    sum += i;
              //      Thread.sleep(10);
                }
                return sum;
            }
        });
        executorService = Executors.newFixedThreadPool(1);
        taskSubmitter = new TaskSubmitter(executorService, future);
        taskSubmitter.submitTask();
        threadPoolComputation = new ThreadPoolComputation(future);
        resultGetter = new ResultGetter<Long>(threadPoolComputation);
        resultGetter.attemptGet();
        LOGGER.debug("result Getter type "+resultGetter.getResultGetterType().getSimpleName());
        assertEquals("Long",resultGetter.getResultGetterType().getSimpleName());


    }
}
