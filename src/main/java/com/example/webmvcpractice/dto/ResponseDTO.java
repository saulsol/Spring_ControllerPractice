package com.example.webmvcpractice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Builder
@Getter
@Setter
public class ResponseDTO<T> {

    private String error;
    private List<T> data;
}
