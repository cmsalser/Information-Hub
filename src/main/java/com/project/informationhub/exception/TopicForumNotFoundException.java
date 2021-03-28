package com.project.informationhub.exception;

public class TopicForumNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

    public TopicForumNotFoundException(Long Id) {
        super("Could Not Find Topic Forum: " + Id);
    }
}
