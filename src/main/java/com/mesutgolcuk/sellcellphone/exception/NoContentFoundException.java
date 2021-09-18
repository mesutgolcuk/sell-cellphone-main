package com.mesutgolcuk.sellcellphone.exception;

public class NoContentFoundException extends Exception {
    public NoContentFoundException() {
        super("No content found");
    }

    public NoContentFoundException(String message) {
        super(message);
    }
}
