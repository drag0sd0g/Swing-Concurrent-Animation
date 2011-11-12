package net.teamsparq.animation.concurrency.future;

/**
 * Created by IntelliJ IDEA.
 * User: dragos
 * Date: 12/11/11
 * Time: 14:19
 * To change this template use File | Settings | File Templates.
 */

import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Abstraction of the attempt to obtain a future result from a thread pool
 */
public class ResultGetter<T> {
    private final ThreadPoolComputation<T> threadPoolComputation;

    public ResultGetter(ThreadPoolComputation<T> threadPool) {
        this.threadPoolComputation = threadPool;
    }


    public T attemptGet() {
        try {
            return threadPoolComputation.getResult();
        } catch (InterruptedException ex) {
            Logger.getLogger(ResultGetter.class.getName()).log(Level.SEVERE, "current thread was interrupted while waiting", ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(ResultGetter.class.getName()).log(Level.SEVERE, "computation threw an exception", ex);
        }
        return null;
    }

}