package net.teamsparq.animation.concurrency.swing;

import static junit.framework.Assert.*;

import net.teamsparq.animation.concurrency.swing.impl.SwingFrameImpl;
import org.junit.Before;
import org.junit.Test;

public class TestSwingFrameImpl {

    private SwingFrameImpl swingFrame;

    @Before
    public void setUp() {
        swingFrame = new SwingFrameImpl();
    }

    @Test
    /**
     * Check whether the main frame's width and height have been properly initialized with the defaults from the
     * SwingFrameInterface
     */
    public void checkMainFrameBoundaries() {
        assertEquals(SwingFrameImpl.FRAME_WIDTH, swingFrame.getWidth());
        assertEquals(SwingFrameImpl.FRAME_HEIGHT, swingFrame.getHeight());
    }

}
