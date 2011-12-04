package net.teamsparq.animation.concurrency.controller;

import net.teamsparq.animation.concurrency.future.ResultGetter;
import net.teamsparq.animation.concurrency.future.TaskSubmitter;
import net.teamsparq.animation.concurrency.future.ThreadPoolComputation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;


/**
 * Controller for the future value animation frame. It encompasses the main parts of the process:
 * <ul>
 * <li> 1) submission of future to executor service </li>
 * <li> 2) checking for computation status </li>
 * <li> 3) retrieving the future result </li>
 * </ul>
 */

public class SwingFrameFutureController {
    private final ExecutorService executorService;
    private final TaskSubmitter taskSubmitter;
    private final ThreadPoolComputation threadPoolComputation;
    private final ResultGetter resultGetter;

    public <T> SwingFrameFutureController(FutureTask<T> future) {
        executorService = Executors.newFixedThreadPool(1);
        taskSubmitter = new TaskSubmitter(executorService, future);
        threadPoolComputation = new ThreadPoolComputation(future);
        resultGetter = new ResultGetter(threadPoolComputation);
    }


    /**
     * delegates task submission to the encompassing TaskSubmitter object
     */
    public void submitToExecutorService() {
        taskSubmitter.submitTask();
    }

    /**
     * delegates result-retrieving attempt to the encompassing ResultGetter object
     */
    public String attemptToRetrieveResult() {
        return resultGetter.attemptGet().toString();
    }

    /**
     * delegates 'done' status checking to the encompassing ThreadPoolComputation object
     */
    public boolean isDoneComputing() {
        return threadPoolComputation.isReady();
    }

}
