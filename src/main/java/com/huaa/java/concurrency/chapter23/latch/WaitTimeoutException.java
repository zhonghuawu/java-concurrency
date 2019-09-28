package com.huaa.java.concurrency.chapter23.latch;

public class WaitTimeoutException extends Exception {

    public WaitTimeoutException(String message) {
        super(message);
    }
}
