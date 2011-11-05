package net.teamsparq.animation.concurrency.swing;

import javax.swing.JComponent;


public interface Animatable {
    public void animateLeftToRight(JComponent component, int startPosition, int endPosition, int stepRate);
}
