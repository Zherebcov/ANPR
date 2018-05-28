package com.project.anpr.exception;

import org.hibernate.service.spi.ServiceException;

@SuppressWarnings("serial")
public class AlreadyExitException extends ServiceException{

	public AlreadyExitException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
