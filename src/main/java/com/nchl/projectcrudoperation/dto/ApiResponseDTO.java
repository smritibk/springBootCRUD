package com.nchl.projectcrudoperation.dto;

import java.time.LocalDateTime;

public class ApiResponseDTO<T> {
    private LocalDateTime timestamp;
    private String status;
    private String message;
    private T data;

    public ApiResponseDTO(LocalDateTime timestamp, String status, String message, T data) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
