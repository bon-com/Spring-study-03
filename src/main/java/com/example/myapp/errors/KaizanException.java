package com.example.myapp.errors;

public class KaizanException extends RuntimeException{
	public KaizanException () {
		super();
	}
	public KaizanException(String message) {
        super(message);
    }
    public KaizanException(String message, Throwable cause) {
        super(message, cause);
    }

    public KaizanException(Throwable cause) {
        super(cause);
    }
}
