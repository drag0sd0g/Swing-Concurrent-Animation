package net.teamsparq.animation.concurrency.future;

/**
 * Created by IntelliJ IDEA.
 * User: dragos
 * Date: 12/11/11
 * Time: 14:20
 * To change this template use File | Settings | File Templates.
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Wrapper around a FutureTask encompassing the passing of a future to an executor service
 */
public class TaskSubmitter {
    private final ExecutorService executorService;
    private final FutureTask future;

    public TaskSubmitter(ExecutorService executorService, FutureTask future) {
        this.executorService = executorService;
        this.future = future;
    }

    public void submitTask(){
        Logger.getLogger(TaskSubmitter.class.getName()).log(Level.INFO,"submitting future to executor");
        executorService.execute(future);
    }

}