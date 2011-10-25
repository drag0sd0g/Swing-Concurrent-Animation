package net.teamsparq.animation.concurrency.swing;

import static junit.framework.Assert.*;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestSwingFrameFuture {
    private SwingFrameFuture sff;
    Properties properties;

    @Before
    public void setUp(){
        sff = new SwingFrameFuture();
        properties = new Properties();
    	try {
       		properties.load(new FileInputStream("src/main/resources/properties/FutureCodeProperties"));
            } catch (IOException ex) {
        }
    }

    @Test
    public void testCodeAreaBoundaries(){
        assertEquals(SwingFrameFuture.CODE_AREA_HEIGHT,sff.getCodeArea().getHeight());
        assertEquals(SwingFrameFuture.CODE_AREA_WIDTH,sff.getCodeArea().getWidth());
        assertEquals(SwingFrameFuture.CODE_AREA_X,sff.getCodeArea().getX());
        assertEquals(SwingFrameFuture.CODE_AREA_X,sff.getCodeArea().getY());
    }

    @Test
    public void testTaskSubmitterBoundaries(){
        assertEquals(SwingFrameFuture.TASK_SUBMITTER_HEIGHT,sff.getTaskSubmitter().getHeight());
        assertEquals(SwingFrameFuture.TASK_SUBMITTER_WIDTH,sff.getTaskSubmitter().getWidth());
        assertEquals(SwingFrameFuture.TASK_SUBMITTER_X,sff.getTaskSubmitter().getX());
        assertEquals(SwingFrameFuture.TASK_SUBMITTER_Y,sff.getTaskSubmitter().getY());
    }

    @Test
    public void testTaskSubmitterInfoBoundaries(){
        assertEquals(SwingFrameFuture.TASK_SUBMITTER_INFO_HEIGHT,sff.getTaskSubmitterInfo().getHeight());
        assertEquals(SwingFrameFuture.TASK_SUBMITTER_INFO_WIDTH,sff.getTaskSubmitterInfo().getWidth());
        assertEquals(SwingFrameFuture.TASK_SUBMITTER_INFO_X,sff.getTaskSubmitterInfo().getX());
        assertEquals(SwingFrameFuture.TASK_SUBMITTER_INFO_Y,sff.getTaskSubmitterInfo().getY());
    }

    @Test
    public void testThreadPoolBoundaries(){
        assertEquals(SwingFrameFuture.THREAD_POOL_HEIGHT,sff.getThreadPool().getHeight());
        assertEquals(SwingFrameFuture.THREAD_POOL_WIDTH,sff.getThreadPool().getWidth());
        assertEquals(SwingFrameFuture.THREAD_POOL_X,sff.getThreadPool().getX());
        assertEquals(SwingFrameFuture.THREAD_POOL_Y,sff.getThreadPool().getY());
    }

    @Test
    public void testThreadPoolInfoBoundaries(){
        assertEquals(SwingFrameFuture.THREAD_POOL_INFO_HEIGHT,sff.getThreadPoolInfo().getHeight());
        assertEquals(SwingFrameFuture.THREAD_POOL_INFO_WIDTH,sff.getThreadPoolInfo().getWidth());
        assertEquals(SwingFrameFuture.THREAD_POOL_INFO_X,sff.getThreadPoolInfo().getX());
        assertEquals(SwingFrameFuture.THREAD_POOL_INFO_Y,sff.getThreadPoolInfo().getY());
    }

    @Test
    public void testResultGetterBoundaries(){
        assertEquals(SwingFrameFuture.RESULT_GETTER_HEIGHT,sff.getResultGetter().getHeight());
        assertEquals(SwingFrameFuture.RESULT_GETTER_WIDTH,sff.getResultGetter().getWidth());
        assertEquals(SwingFrameFuture.RESULT_GETTER_X,sff.getResultGetter().getX());
        assertEquals(SwingFrameFuture.RESULT_GETTER_Y,sff.getResultGetter().getY());
    }

    @Test
    public void testCodeAreaValues(){
        assertEquals(sff.getInitialCode(),properties.getProperty("initialCode"));
        assertEquals(sff.getWaitForResultCode(),properties.getProperty("waitForResultCode"));
        assertEquals(sff.getStartExecutionBoldCode(),properties.getProperty("startExecutionBoldCode"));
        assertEquals(sff.getGetFutureCode(),properties.getProperty("getFutureCode"));
    }

    @Test
    public void testAnimation(){
        JComponent testLabel = new JLabel();
        testLabel.setBounds(0,0,10,10);
        sff.animateLeftToRight(testLabel,testLabel.getX(),30,5);
        assertEquals(testLabel.getX(),30);
    }
}
