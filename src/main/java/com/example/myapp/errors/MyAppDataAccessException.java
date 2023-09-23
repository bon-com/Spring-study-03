package com.example.myapp.errors;

public class MyAppDataAccessException extends RuntimeException{
	public MyAppDataAccessException () {
		super();
	}
	public MyAppDataAccessException(String message) {
        super(message);
    }
    public MyAppDataAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyAppDataAccessException(Throwable cause) {
        super(cause);
    }
}
