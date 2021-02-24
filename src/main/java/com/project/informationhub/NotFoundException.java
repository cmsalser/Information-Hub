package com.project.informationhub;

public class NotFoundException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    public NotFoundException(Long Id) {
        super("Could Not Find : " + Id);
    }
}
