package com.springbootproject.unitconverter.dto;

public class ExceptionResponseDto {
    private Integer status;
    private String message;

    public ExceptionResponseDto( Integer status,String message) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
