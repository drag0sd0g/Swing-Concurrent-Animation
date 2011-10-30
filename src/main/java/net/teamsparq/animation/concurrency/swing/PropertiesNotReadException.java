package net.teamsparq.animation.concurrency.swing;

public class PropertiesNotReadException extends RuntimeException {
    public String getMessage() {
        return "Properties have not been read due to an IOException. TestSwingFrameFuture failed.";
    }
}
