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
    public void checkMainFrameBoundaries(){
        assertEquals(600,swingFrame.getWidth());
        assertEquals(600,swingFrame.getHeight());
    }

}
