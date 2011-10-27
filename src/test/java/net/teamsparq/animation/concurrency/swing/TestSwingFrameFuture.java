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
  private Properties properties;

  @Before
  public void setUp() {
  sff = new SwingFrameFuture();
  properties = new Properties();
  try {
  properties.load(new FileInputStream("src/main/resources/properties/FutureCodeProperties"));
      } catch (IOException ex) {
  }
 }

  @Test
  public void ensureCodeAreaDoesntOverlapPanelAndHasValidCoordinates() {
   assertEquals(SwingFrameFuture.CODE_AREA_HEIGHT, sff.getCodeArea().getHeight());
   assertEquals(SwingFrameFuture.CODE_AREA_WIDTH, sff.getCodeArea().getWidth());
   assertEquals(SwingFrameFuture.CODE_AREA_X, sff.getCodeArea().getX());
   assertEquals(SwingFrameFuture.CODE_AREA_X, sff.getCodeArea().getY());
   assertTrue(sff.getCodeArea().getHeight() <= SwingFrameFuture.FRAME_HEIGHT);
   assertTrue(sff.getCodeArea().getWidth() <= SwingFrameFuture.FRAME_WIDTH);
  }

  @Test
  public void ensureTaskSubmitterDoesntOverlapPanelAndHasValidCoordinates() {
   assertEquals(SwingFrameFuture.TASK_SUBMITTER_HEIGHT, sff.getTaskSubmitter().getHeight());
   assertEquals(SwingFrameFuture.TASK_SUBMITTER_WIDTH, sff.getTaskSubmitter().getWidth());
   assertEquals(SwingFrameFuture.TASK_SUBMITTER_X, sff.getTaskSubmitter().getX());
   assertEquals(SwingFrameFuture.TASK_SUBMITTER_Y, sff.getTaskSubmitter().getY());
   assertTrue(sff.getTaskSubmitter().getHeight() <= SwingFrameFuture.FRAME_HEIGHT);
   assertTrue(sff.getTaskSubmitter().getWidth() <= SwingFrameFuture.FRAME_WIDTH);
  }

  @Test
  public void ensureTaskSubmitterInfoDoesntOverlapPanelAndHasValidCoordinates() {
   assertEquals(SwingFrameFuture.TASK_SUBMITTER_INFO_HEIGHT, sff.getTaskSubmitterInfo().getHeight());
   assertEquals(SwingFrameFuture.TASK_SUBMITTER_INFO_WIDTH, sff.getTaskSubmitterInfo().getWidth());
   assertEquals(SwingFrameFuture.TASK_SUBMITTER_INFO_X, sff.getTaskSubmitterInfo().getX());
   assertEquals(SwingFrameFuture.TASK_SUBMITTER_INFO_Y, sff.getTaskSubmitterInfo().getY());
   assertTrue(sff.getTaskSubmitterInfo().getHeight() <= SwingFrameFuture.FRAME_HEIGHT);
   assertTrue(sff.getTaskSubmitterInfo().getWidth() <= SwingFrameFuture.FRAME_WIDTH);
  }

  @Test
  public void ensureThreadPoolDoesntOverlapPanelAndHasValidCoordinates() {
   assertEquals(SwingFrameFuture.THREAD_POOL_HEIGHT, sff.getThreadPool().getHeight());
   assertEquals(SwingFrameFuture.THREAD_POOL_WIDTH, sff.getThreadPool().getWidth());
   assertEquals(SwingFrameFuture.THREAD_POOL_X, sff.getThreadPool().getX());
   assertEquals(SwingFrameFuture.THREAD_POOL_Y, sff.getThreadPool().getY());
   assertTrue(sff.getThreadPool().getHeight() <= SwingFrameFuture.FRAME_HEIGHT);
   assertTrue(sff.getThreadPool().getWidth() <= SwingFrameFuture.FRAME_WIDTH);
  }

  @Test
  public void ensureThreadPoolInfoDoesntOverlapPanelAndHasValidCoordinates() {
   assertEquals(SwingFrameFuture.THREAD_POOL_INFO_HEIGHT, sff.getThreadPoolInfo().getHeight());
   assertEquals(SwingFrameFuture.THREAD_POOL_INFO_WIDTH, sff.getThreadPoolInfo().getWidth());
   assertEquals(SwingFrameFuture.THREAD_POOL_INFO_X, sff.getThreadPoolInfo().getX());
   assertEquals(SwingFrameFuture.THREAD_POOL_INFO_Y, sff.getThreadPoolInfo().getY());
   assertTrue(sff.getThreadPoolInfo().getHeight() <= SwingFrameFuture.FRAME_HEIGHT);
   assertTrue(sff.getThreadPoolInfo().getWidth() <= SwingFrameFuture.FRAME_WIDTH);
  }

  @Test
  public void ensureResultGetterDoesntOverlapPanelAndHasValidCoordinates() {
   assertEquals(SwingFrameFuture.RESULT_GETTER_HEIGHT, sff.getResultGetter().getHeight());
   assertEquals(SwingFrameFuture.RESULT_GETTER_WIDTH, sff.getResultGetter().getWidth());
   assertEquals(SwingFrameFuture.RESULT_GETTER_X, sff.getResultGetter().getX());
   assertEquals(SwingFrameFuture.RESULT_GETTER_Y, sff.getResultGetter().getY());
   assertTrue(sff.getResultGetter().getHeight() <= SwingFrameFuture.FRAME_HEIGHT);
   assertTrue(sff.getResultGetter().getWidth() <= SwingFrameFuture.FRAME_WIDTH);
  }

  @Test
  public void verifyCodeAreaTextInConcordanceWithProperties() {
   assertEquals(sff.getInitialCode(), properties.getProperty("initialCode"));
   assertEquals(sff.getWaitForResultCode(), properties.getProperty("waitForResultCode"));
   assertEquals(sff.getStartExecutionBoldCode(), properties.getProperty("startExecutionBoldCode"));
   assertEquals(sff.getGetFutureCode(), properties.getProperty("getFutureCode"));
  }

  @Test
  public void ensureValidChangesOccurWhenAnimatingLeftToRight() {
   JComponent testLabel = new JLabel();
   testLabel.setBounds(0, 0, 10, 10);
   sff.animateLeftToRight(testLabel, testLabel.getX(), 30, 5);
   assertEquals(testLabel.getX(), 30);
  }
}
