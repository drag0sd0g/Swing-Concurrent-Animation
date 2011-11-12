package net.teamsparq.animation.concurrency.swing.impl;

import net.teamsparq.animation.concurrency.swing.SwingFrameInterface;

import javax.swing.*;


public class SwingFrameImpl extends JFrame implements SwingFrameInterface {
    //frame coordinates
    public static final int FRAME_WIDTH = 600;
    public static final int FRAME_HEIGHT = 600;

    public SwingFrameImpl() {
        setLayout(null);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

}
