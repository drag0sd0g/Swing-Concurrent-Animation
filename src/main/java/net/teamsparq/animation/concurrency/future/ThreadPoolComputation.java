package net.teamsparq.animation.concurrency.future;

/**
 * Created by IntelliJ IDEA.
 * User: dragos
 * Date: 12/11/11
 * Time: 14:19
 * To change this template use File | Settings | File Templates.
 */
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


/**
 * Abstraction of the future's computation inside an executor service (thread pool)
 * The purpose is to return the status of the computation (ready | in progress) and to obtain the future value
 */
public class ThreadPoolComputation<T> {
    private final FutureTask<T> future;

    public ThreadPoolComputation(FutureTask<T> future) {
        this.future = future;
    }

    public boolean isReady(){
        return future.isDone();
    }

    public T getResult() throws InterruptedException, ExecutionException{
        return future.get();
    }
}