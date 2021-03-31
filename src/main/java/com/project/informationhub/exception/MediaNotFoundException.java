package com.project.informationhub.exception;

public class MediaNotFoundException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    public MediaNotFoundException(Long Id) {
        super("Could Not Find Media : " + Id);
    }
}
