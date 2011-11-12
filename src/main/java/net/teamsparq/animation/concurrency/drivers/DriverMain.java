package net.teamsparq.animation.concurrency.drivers;

import net.teamsparq.animation.concurrency.swing.impl.SwingFrameFuture;

public class DriverMain {
    public static void main(String[] args) {
        new SwingFrameFuture().beginAnimation();
    }
}
