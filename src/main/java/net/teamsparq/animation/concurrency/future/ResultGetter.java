package net.teamsparq.animation.concurrency.future;

/**
 * Created by IntelliJ IDEA.
 * User: dragos
 * Date: 12/11/11
 * Time: 14:19
 * To change this template use File | Settings | File Templates.
 */

import javax.lang.model.element.TypeParameterElement;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Abstraction of the attempt to obtain a future result from a thread pool
 */
public class ResultGetter<T> {
    private final ThreadPoolComputation<T> threadPoolComputation;
    public T result;

    public ResultGetter(ThreadPoolComputation<T> threadPool) {
        this.threadPoolComputation = threadPool;
        result = null;
    }


    public T attemptGet() {
        try {
            result = threadPoolComputation.getResult();
            return result;
        } catch (InterruptedException ex) {
            Logger.getLogger(ResultGetter.class.getName()).log(Level.SEVERE, "current thread was interrupted while waiting", ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(ResultGetter.class.getName()).log(Level.SEVERE, "computation threw an exception", ex);
        }
        return result;
    }

    public Class getResultGetterType() throws ClassNotFoundException, NoSuchFieldException {
        return result.getClass();
    }

}