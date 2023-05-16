package com.example.webmvcpractice.exception;

public class MemberException extends BaseException {

    private final BaseExceptionType exceptionType;

    public MemberException(BaseExceptionType exceptionType){
        this.exceptionType = exceptionType;
    }

    @Override
    public BaseExceptionType getBaseExceptionType() {
        return exceptionType;
    }
}
