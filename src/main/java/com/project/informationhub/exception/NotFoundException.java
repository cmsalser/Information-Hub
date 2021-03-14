package com.project.informationhub.exception;

public class NotFoundException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    public NotFoundException(Long Id) {
        super("Could Not Find : " + Id);
    }
}
