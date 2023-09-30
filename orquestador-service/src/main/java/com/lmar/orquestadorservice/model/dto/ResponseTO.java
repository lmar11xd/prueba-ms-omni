package com.lmar.orquestadorservice.model.dto;

public class ResponseTO<T> {
    private int status;
    private String message;
    private T data;
}
