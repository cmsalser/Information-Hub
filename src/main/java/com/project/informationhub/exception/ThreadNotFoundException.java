package com.informationHub.exception;

public class ThreadNotFoundException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    public ThreadNotFoundException(int Id) {
        super("Could Not Find Thread: " + Id);
    }
}
