package com.example.webmvcpractice.exception;

public abstract class BaseException extends RuntimeException {
    public abstract BaseExceptionType getBaseExceptionType();
}
