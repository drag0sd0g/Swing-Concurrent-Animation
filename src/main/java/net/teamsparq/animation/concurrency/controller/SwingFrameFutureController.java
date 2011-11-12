package net.teamsparq.animation.concurrency.controller;

/**
 * Created by IntelliJ IDEA.
 * User: dragos
 * Date: 12/11/11
 * Time: 14:26
 * To change this template use File | Settings | File Templates.
 */
import net.teamsparq.animation.concurrency.future.ResultGetter;
import net.teamsparq.animation.concurrency.future.TaskSubmitter;
import net.teamsparq.animation.concurrency.future.ThreadPoolComputation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;


/**
 * Controller for the future value animation frame. It encompasses the main parts of the process:
 * 1) submission of future to executor service
 * 2) checking for computation status
 * 3) retrieving the future result
 */

public class SwingFrameFutureController {
    private final ExecutorService executorService;
    private final TaskSubmitter taskSubmitter;
    private final ThreadPoolComputation threadPoolComputation;
    private final ResultGetter resultGetter;

    public <T> SwingFrameFutureController(FutureTask<T> future){
        executorService = Executors.newFixedThreadPool(1);
        taskSubmitter = new TaskSubmitter(executorService, future);
        threadPoolComputation = new ThreadPoolComputation(future);
        resultGetter = new ResultGetter(threadPoolComputation);
    }

    public void submitToExecutorService(){
        taskSubmitter.submitTask();
    }

    public String attemptToRetrieveResult(){
        return resultGetter.attemptGet().toString();
    }

    public boolean isDoneComputing(){
        return threadPoolComputation.isReady();
    }

}
