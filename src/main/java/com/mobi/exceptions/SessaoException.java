package com.mobi.exceptions;

public class SessaoException extends RuntimeException {
    private final String     message;
    private final String     errorReason;

    public SessaoException(String message, String errorReason) {
        this.message = message;
        this.errorReason = errorReason;
    }

    public SessaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String message1, String errorReason) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.message = message1;
        this.errorReason = errorReason;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getErrorReason() {
        return errorReason;
    }
}
