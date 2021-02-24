package com.project.informationhub.ContactUs;

public class ContactUsNotFoundException extends RuntimeException{
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public ContactUsNotFoundException(Long Id) {
        super("Could Not Find : " + Id);
    }
}
