package net.teamsparq.animation.concurrency.future;

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

    public boolean isReady() {
        return future.isDone();
    }

    public T getResult() throws InterruptedException, ExecutionException {
        return future.get();
    }
}