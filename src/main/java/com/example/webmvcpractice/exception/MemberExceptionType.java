package com.example.webmvcpractice.exception;

import org.springframework.http.HttpStatus;

public enum MemberExceptionType implements BaseExceptionType {

    ALREADY_EXIST_USERNAME(600, HttpStatus.OK, "이미 존재하는 아이디 입니다"),
    NOT_FOUND_MEMBER(601, HttpStatus.OK, "회원 정보가 없습니다.");

    ;

    private final int errorCode;
    private final HttpStatus httpStatus;
    private final String errorMessage;

    MemberExceptionType(int errorCode, HttpStatus httpStatus, String errorMessage) {
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
    }

    @Override
    public int getErrorCode() {
        return this.errorCode;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    @Override
    public String getErrorMessage() {
        return this.errorMessage;
    }
}
