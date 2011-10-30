package net.teamsparq.animation.concurrency.swing;

import static junit.framework.Assert.*;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class TestSwingFrameFuture {
    private SwingFrameFuture sff;
    private static Properties properties;
    private static Logger logger;

    @BeforeClass
    public static void propertiesInitializer() {
        logger = org.apache.log4j.Logger.getLogger(TestSwingFrameFuture.class);
        BasicConfigurator.configure();
        properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/FutureCodeProperties"));
        } catch (IOException ex) {
          logger.error("Properties have not been read due to an IOException. TestSwingFrameFuture failed.");
          System.exit(0);
        }
    }

    @Before
    public void setUp() {
        sff = new SwingFrameFuture();
    }

    @Test
    /**
     *Testing whether the code area is correctly assigned its coordinates at initialization time and whether it's within
     *the main frame's boundaries
     **/
    public void ensureCodeAreaDoesntOverlapPanelAndHasValidCoordinates() {
        logger.info("testing ensureCodeAreaDoesntOverlapPanelAndHasValidCoordinates()...");
        assertEquals(SwingFrameFuture.CODE_AREA_HEIGHT, sff.getCodeArea().getHeight());
        assertEquals(SwingFrameFuture.CODE_AREA_WIDTH, sff.getCodeArea().getWidth());
        assertEquals(SwingFrameFuture.CODE_AREA_X, sff.getCodeArea().getX());
        assertEquals(SwingFrameFuture.CODE_AREA_X, sff.getCodeArea().getY());
        assertTrue(sff.getCodeArea().getHeight() <= SwingFrameInterface.FRAME_HEIGHT);
        assertTrue(sff.getCodeArea().getWidth() <= SwingFrameInterface.FRAME_WIDTH);
    }

    @Test
    /**
     *Testing whether the task submitter label is correctly assigned its coordinates at initialization time and whether
     *it's within the main frame's boundaries
     **/
    public void ensureTaskSubmitterDoesntOverlapPanelAndHasValidCoordinates() {
        logger.info("testing ensureTaskSubmitterDoesntOverlapPanelAndHasValidCoordinates()...");
        assertEquals(SwingFrameFuture.TASK_SUBMITTER_HEIGHT, sff.getTaskSubmitter().getHeight());
        assertEquals(SwingFrameFuture.TASK_SUBMITTER_WIDTH, sff.getTaskSubmitter().getWidth());
        assertEquals(SwingFrameFuture.TASK_SUBMITTER_X, sff.getTaskSubmitter().getX());
        assertEquals(SwingFrameFuture.TASK_SUBMITTER_Y, sff.getTaskSubmitter().getY());
        assertTrue(sff.getTaskSubmitter().getHeight() <= SwingFrameInterface.FRAME_HEIGHT);
        assertTrue(sff.getTaskSubmitter().getWidth() <= SwingFrameInterface.FRAME_WIDTH);
    }

    @Test
    /**
     *Testing whether task submitter info label is correctly assigned its coordinates at initialization time and whether
     *it's within the main frame's boundaries
     **/
    public void ensureTaskSubmitterInfoDoesntOverlapPanelAndHasValidCoordinates() {
        logger.info("testing ensureTaskSubmitterInfoDoesntOverlapPanelAndHasValidCoordinates()...");
        assertEquals(SwingFrameFuture.TASK_SUBMITTER_INFO_HEIGHT, sff.getTaskSubmitterInfo().getHeight());
        assertEquals(SwingFrameFuture.TASK_SUBMITTER_INFO_WIDTH, sff.getTaskSubmitterInfo().getWidth());
        assertEquals(SwingFrameFuture.TASK_SUBMITTER_INFO_X, sff.getTaskSubmitterInfo().getX());
        assertEquals(SwingFrameFuture.TASK_SUBMITTER_INFO_Y, sff.getTaskSubmitterInfo().getY());
        assertTrue(sff.getTaskSubmitterInfo().getHeight() <= SwingFrameInterface.FRAME_HEIGHT);
        assertTrue(sff.getTaskSubmitterInfo().getWidth() <= SwingFrameInterface.FRAME_WIDTH);
    }

    @Test
    /**
     *Testing whether the thread pool is correctly assigned its coordinates at initialization time and whether it's within
     *the main frame's boundaries
     **/
    public void ensureThreadPoolDoesntOverlapPanelAndHasValidCoordinates() {
        logger.info("testing ensureThreadPoolDoesntOverlapPanelAndHasValidCoordinates()...");
        assertEquals(SwingFrameFuture.THREAD_POOL_HEIGHT, sff.getThreadPool().getHeight());
        assertEquals(SwingFrameFuture.THREAD_POOL_WIDTH, sff.getThreadPool().getWidth());
        assertEquals(SwingFrameFuture.THREAD_POOL_X, sff.getThreadPool().getX());
        assertEquals(SwingFrameFuture.THREAD_POOL_Y, sff.getThreadPool().getY());
        assertTrue(sff.getThreadPool().getHeight() <= SwingFrameInterface.FRAME_HEIGHT);
        assertTrue(sff.getThreadPool().getWidth() <= SwingFrameInterface.FRAME_WIDTH);
    }

    @Test
    /**
     *Testing whether the thread pool info label is correctly assigned its coordinates at initialization time and whether
     *it's within the main frame's boundaries
     **/
    public void ensureThreadPoolInfoDoesntOverlapPanelAndHasValidCoordinates() {
        logger.info("testing ensureThreadPoolInfoDoesntOverlapPanelAndHasValidCoordinates()...");
        assertEquals(SwingFrameFuture.THREAD_POOL_INFO_HEIGHT, sff.getThreadPoolInfo().getHeight());
        assertEquals(SwingFrameFuture.THREAD_POOL_INFO_WIDTH, sff.getThreadPoolInfo().getWidth());
        assertEquals(SwingFrameFuture.THREAD_POOL_INFO_X, sff.getThreadPoolInfo().getX());
        assertEquals(SwingFrameFuture.THREAD_POOL_INFO_Y, sff.getThreadPoolInfo().getY());
        assertTrue(sff.getThreadPoolInfo().getHeight() <= SwingFrameInterface.FRAME_HEIGHT);
        assertTrue(sff.getThreadPoolInfo().getWidth() <= SwingFrameInterface.FRAME_WIDTH);
    }

    @Test
    /**
     *Testing whether the result getter is correctly assigned its coordinates at initialization time and whether it's
     *within the main frame's boundaries
     **/
    public void ensureResultGetterDoesntOverlapPanelAndHasValidCoordinates() {
        logger.info("testing ensureResultGetterDoesntOverlapPanelAndHasValidCoordinates()...");
        assertEquals(SwingFrameFuture.RESULT_GETTER_HEIGHT, sff.getResultGetter().getHeight());
        assertEquals(SwingFrameFuture.RESULT_GETTER_WIDTH, sff.getResultGetter().getWidth());
        assertEquals(SwingFrameFuture.RESULT_GETTER_X, sff.getResultGetter().getX());
        assertEquals(SwingFrameFuture.RESULT_GETTER_Y, sff.getResultGetter().getY());
        assertTrue(sff.getResultGetter().getHeight() <= SwingFrameInterface.FRAME_HEIGHT);
        assertTrue(sff.getResultGetter().getWidth() <= SwingFrameInterface.FRAME_WIDTH);
    }

    @Test
    /**
     *Testing whether the strings which populate the code area are correctly initialized from the properties file
     **/
    public void verifyCodeAreaTextInConcordanceWithProperties() {
        logger.info("testing verifyCodeAreaTextInConcordanceWithProperties()...");
        assertEquals(sff.getInitialCode(), properties.getProperty("initialCode"));
        assertEquals(sff.getWaitForResultCode(), properties.getProperty("waitForResultCode"));
        assertEquals(sff.getStartExecutionBoldCode(), properties.getProperty("startExecutionBoldCode"));
        assertEquals(sff.getGetFutureCode(), properties.getProperty("getFutureCode"));
    }

    @Test
    /**
     *Testing whether the implemented animation method 'animateLeftToRight' correctly changes its argument's coordinates
     *to simulate movement from left to right
     **/
    public void ensureValidChangesOccurWhenAnimatingLeftToRight() {
        logger.info("testing ensureValidChangesOccurWhenAnimatingLeftToRight()...");
        JComponent testLabel = new JLabel();
        testLabel.setBounds(0, 0, 10, 10);
        sff.animateLeftToRight(testLabel, testLabel.getX(), 30, 5);
        assertEquals(testLabel.getX(), 30);
    }
}
