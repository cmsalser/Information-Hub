package com.project.informationhub.FAQ;

public class FAQNotFoundException extends RuntimeException{
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public FAQNotFoundException(Long Id) {
        super("Could Not Find : " + Id);
    }
}
