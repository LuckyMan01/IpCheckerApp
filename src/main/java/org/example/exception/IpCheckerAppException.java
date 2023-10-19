package org.example.exception;

public class BlacklistServiceException extends RuntimeException {
    public BlacklistServiceException() {
    }

    public BlacklistServiceException(String massage) {
        super(massage);
    }

    public BlacklistServiceException(Throwable cause) {
        super(cause);
    }

    public BlacklistServiceException(String massage, Throwable cause) {
        super(massage, cause);
    }
}
