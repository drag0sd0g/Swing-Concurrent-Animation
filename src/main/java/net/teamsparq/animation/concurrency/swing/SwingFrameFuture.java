package net.teamsparq.animation.concurrency.swing;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SwingFrameFuture extends SwingFrameImpl implements Animatable {
    // code area coordinates
    public static final int CODE_AREA_X = 0;
    public static final int CODE_AREA_Y = 0;
    public static final int CODE_AREA_WIDTH = 460;
    public static final int CODE_AREA_HEIGHT = 400;

    // task submitter label coordinates
    public static final int TASK_SUBMITTER_X = 30;
    public static final int TASK_SUBMITTER_Y = 400;
    public static final int TASK_SUBMITTER_WIDTH = 50;
    public static final int TASK_SUBMITTER_HEIGHT = 50;

    // task submitter info label coordinates
    public static final int TASK_SUBMITTER_INFO_X = 30;
    public static final int TASK_SUBMITTER_INFO_Y = 420;
    public static final int TASK_SUBMITTER_INFO_WIDTH = 500;
    public static final int TASK_SUBMITTER_INFO_HEIGHT = 100;

    // thread pool label coordinates
    public static final int THREAD_POOL_X = 250;
    public static final int THREAD_POOL_Y = 400;
    public static final int THREAD_POOL_WIDTH = 50;
    public static final int THREAD_POOL_HEIGHT = 50;

    // thread pool info label coordinates
    public static final int THREAD_POOL_INFO_X = 30;
    public static final int THREAD_POOL_INFO_Y = 420;
    public static final int THREAD_POOL_INFO_WIDTH = 500;
    public static final int THREAD_POOL_INFO_HEIGHT = 100;

    // result getter label coordinates
    public static final int RESULT_GETTER_X = 300;
    public static final int RESULT_GETTER_Y = 400;
    public static final int RESULT_GETTER_WIDTH = 50;
    public static final int RESULT_GETTER_HEIGHT = 50;

    // Logger
    private static final Logger LOGGER = Logger.getLogger(SwingFrameFuture.class);

    private JEditorPane codeArea;
    private JLabel taskSubmitter;
    private JLabel taskSubmitterInfo;
    private JLabel threadPool;
    private JLabel threadPoolInfo;
    private JLabel resultGetter;
    private boolean available;

    // code Area contents
    private String initialCode;
    private String startExecutionBoldCode;
    private String waitForResultCode;
    private String getFutureCode;

    private static final String propertiesFilePath = "src/main/resources/FutureCodeProperties";

    /**
     * Public no-arg constructor
     */
    public SwingFrameFuture() {
        BasicConfigurator.configure();            // log4j configuration
        init();
        setTitle("Future<V> Example");        // set frame title
        available = false;
    }

    public void beginAnimation() {
        this.submitToExecutorService();
        this.threadPoolComputation();
        this.retrieveResult();
    }

    /**
     * Initializes all frame components & string properties
     */
    private void init() {
        LOGGER.info("initializing components...");
        initProperties(propertiesFilePath);
        initCodeArea();
        initTaskSubmitter();
        initThreadPool();
        initResultGetter();
    }

    /**
     * Initializes properties. If properties file is not found, a file explorer enables the user to locate it manually
     */
    private void initProperties(String propertiesPath) {
        LOGGER.info("initializing properties...");
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(propertiesPath));
            LOGGER.info("properties file loading succeeded");
            initialCode = prop.getProperty("initialCode");
            LOGGER.info("[PROPERTY LOADED] initialCode = "+initialCode);
            startExecutionBoldCode = prop.getProperty("startExecutionBoldCode");
            LOGGER.info("[PROPERTY LOADED] startExecutionBoldCode = "+startExecutionBoldCode);
            waitForResultCode = prop.getProperty("waitForResultCode");
            LOGGER.info("[PROPERTY LOADED] waitForResultCode = "+waitForResultCode);
            getFutureCode = prop.getProperty("getFutureCode");
            LOGGER.info("[PROPERTY LOADED] getFutureCode = "+getFutureCode);
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage());
            JOptionPane.showMessageDialog(this, "Locate the properties file manually","Properties initialization error", JOptionPane.ERROR_MESSAGE);
            JFileChooser fileChooser = new JFileChooser();
            int returnVal = fileChooser.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION){
               initProperties(fileChooser.getSelectedFile().getAbsolutePath());
            }
            else if (returnVal == JFileChooser.CANCEL_OPTION) {
               System.exit(0);
            }
        }
    }

    /**
     * Initializes the code area
     */
    private void initCodeArea() {
        LOGGER.info("initializing code area...");
        codeArea = new JEditorPane("text/html", "");
        codeArea.setText(initialCode);
        codeArea.setBounds(CODE_AREA_X, CODE_AREA_Y, CODE_AREA_WIDTH, CODE_AREA_HEIGHT);
        codeArea.setVisible(true);
        add(codeArea);
    }


    /**
     * Initializes future task submission animation area
     */
    private void initTaskSubmitter() {
        LOGGER.info("initializing task submitter...");
        taskSubmitter = new JLabel();
        taskSubmitter.setIcon(new ImageIcon("src/main/resources/ra.gif"));
        taskSubmitter.setBounds(TASK_SUBMITTER_X, TASK_SUBMITTER_Y, TASK_SUBMITTER_WIDTH, TASK_SUBMITTER_HEIGHT);
        taskSubmitter.setVisible(true);
        add(taskSubmitter);
        taskSubmitterInfo = new JLabel("submitting task to executor");
        taskSubmitterInfo.setBounds(TASK_SUBMITTER_INFO_X, TASK_SUBMITTER_INFO_Y, TASK_SUBMITTER_INFO_WIDTH, TASK_SUBMITTER_INFO_HEIGHT);
        taskSubmitterInfo.setVisible(true);
        add(taskSubmitterInfo);
    }

    /**
     * Initializes thread pool animation area
     */
    private void initThreadPool() {
        LOGGER.info("initializing thread pool...");
        threadPool = new JLabel();
        threadPool.setIcon(new ImageIcon("src/main/resources/loading.gif"));
        threadPool.setBounds(THREAD_POOL_X, THREAD_POOL_Y, THREAD_POOL_WIDTH, THREAD_POOL_HEIGHT);
        threadPool.setVisible(false);
        add(threadPool);
        threadPoolInfo = new JLabel("waiting for task to complete (future not available yet)");
        threadPoolInfo.setBounds(THREAD_POOL_INFO_X, THREAD_POOL_INFO_Y, THREAD_POOL_INFO_WIDTH, THREAD_POOL_INFO_HEIGHT);
        threadPoolInfo.setVisible(false);
        add(threadPoolInfo);
    }

    /**
     * Initializes the obtaining of the future result animation area
     */
    private void initResultGetter() {
        LOGGER.info("initializing result getter");
        resultGetter = new JLabel();
        resultGetter.setIcon(new ImageIcon("src/main/resources/rla.png"));
        resultGetter.setBounds(RESULT_GETTER_X, RESULT_GETTER_Y, RESULT_GETTER_WIDTH, RESULT_GETTER_HEIGHT);
        resultGetter.setVisible(false);
        add(resultGetter);
    }

    /**
     * Simulates the attempt of retrieving a Future result while it has not finished being processed. Graphically, it is
     * the left red arrow trying to obtain the result from the thread pool
     */
    private void attemptGet() {
        LOGGER.info("running attemptGet()...");
        resultGetter.setIcon(new ImageIcon("src/main/resources/rla.png"));
        while (notAvailable()) {
            resultGetter.setVisible(true);
            resultGetter.setVisible(false);
        }
        resultGetter.setIcon(new ImageIcon("src/main/resources/ra.gif"));
        resultGetter.setVisible(true);
        taskSubmitter.setVisible(false);
    }

    /**
     * Start animation for submitting task to an Executor service
     * (i.e. green arrow starts moving right towards the thread pool)
     * The code from the code area which enables the behaviour simulated here is highlighted
     */

    private void submitToExecutorService() {
        LOGGER.info("running submitToExecutorService()...");
        codeArea.setText(startExecutionBoldCode);
        taskSubmitterInfo.setVisible(true);
        animateLeftToRight(taskSubmitter, TASK_SUBMITTER_INFO_X, 200, 10);
    }

    /**
     * Simulates computation of the Future inside the thread pool. Also it launches a separate thread to simulate outer
     * processes attempting to retrieve the Future prematurely
     */

    private void threadPoolComputation() {
        LOGGER.info("running threadPoolComputation");
        codeArea.setText(waitForResultCode);
        threadPool.setVisible(true);
        taskSubmitterInfo.setVisible(false);
        threadPoolInfo.setVisible(true);
        new Thread(new Runnable() {
            public void run() {
                attemptGet();
            }
        }).start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage());
        }
        available = true;
        threadPool.setIcon(new ImageIcon("src/main/resources/tick.jpg"));
    }

    /**
     * Starts animation simulating the retrieval of the computed Future result
     * (i.e. the green arrow moving right with the result, starting from the thread pool)
     */
    private void retrieveResult() {
        LOGGER.info("running retrieveResult()");
        codeArea.setText(getFutureCode);
        threadPoolInfo.setText("retrieving result");
        animateLeftToRight(resultGetter, RESULT_GETTER_X, 500, 10);
        resultGetter.setVisible(false);
    }

    private boolean notAvailable() {
        return available == false;
    }

    public JEditorPane getCodeArea() {
        return codeArea;
    }

    public JLabel getThreadPool() {
        return threadPool;
    }

    public JLabel getThreadPoolInfo() {
        return threadPoolInfo;
    }

    public JLabel getResultGetter() {
        return resultGetter;
    }

    public JLabel getTaskSubmitterInfo() {
        return taskSubmitterInfo;
    }

    public JLabel getTaskSubmitter() {
        return taskSubmitter;
    }

    public String getInitialCode() {
        return initialCode;
    }

    public String getStartExecutionBoldCode() {
        return startExecutionBoldCode;
    }

    public String getWaitForResultCode() {
        return waitForResultCode;
    }

    public String getGetFutureCode() {
        return getFutureCode;
    }

    /**
     * Moves a JComponent from left to right by changing its coordinates each 100 milliseconds
     *
     * @param component     JComponent which will move from left to right
     * @param startPosition initial pixel position on the X axis
     * @param endPosition   final pixel position on the X axis
     * @param stepRate      how many pixels at a time the object will advance
     */
    @Override
    public void animateLeftToRight(JComponent component, int startPosition, int endPosition, int stepRate) {
        for (int i = startPosition; i <= endPosition; i += stepRate) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                LOGGER.error(e.getMessage());
            }
            component.setBounds(i, component.getY(), component.getWidth(), component.getHeight());
        }
    }

}
