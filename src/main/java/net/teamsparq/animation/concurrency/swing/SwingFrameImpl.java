package net.teamsparq.animation.concurrency.swing;

import javax.swing.*;


public class SwingFrameImpl extends JFrame implements SwingFrameInterface {
    public SwingFrameImpl() {
        setLayout(null);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

}
