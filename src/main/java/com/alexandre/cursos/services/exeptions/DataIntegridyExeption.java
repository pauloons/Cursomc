package com.alexandre.cursos.services.exeptions;

public class DataIntegridyExeption extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DataIntegridyExeption(String msg) {
		super(msg);
	}

	public DataIntegridyExeption(String msg, Throwable cause) {
		super(msg, cause);
	}
}
