package net.teamsparq.animation.concurrency.swing;
import static junit.framework.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestSwingFrameImpl {

    private SwingFrameImpl swingFrame;

    @Before
    public void setUp(){
        swingFrame = new SwingFrameImpl();
    }

    @Test
    /**
     * Check whether the main frame's width and height have been properly initialized with the defaults from the
     * SwingFrameInterface
     */
    public void checkMainFrameBoundaries(){
        assertEquals(SwingFrameInterface.FRAME_WIDTH,swingFrame.getWidth());
        assertEquals(SwingFrameInterface.FRAME_HEIGHT,swingFrame.getHeight());
    }

}
