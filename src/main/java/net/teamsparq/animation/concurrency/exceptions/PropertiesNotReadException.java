package net.teamsparq.animation.concurrency.exceptions;

public class PropertiesNotReadException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Properties have not been read due to an IOException. TestSwingFrameFuture failed.";
    }
}
