package com.project.informationhub.exception;

public class ThreadNotFoundException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    public ThreadNotFoundException(Long Id) {
        super("Could Not Find Thread: " + Id);
    }
}
