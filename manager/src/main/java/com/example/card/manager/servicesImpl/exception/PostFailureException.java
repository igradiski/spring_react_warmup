package com.example.card.manager.servicesImpl.exception;

public class PostFailureException  extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public PostFailureException(String exception) {
        super(exception);
    }

}
