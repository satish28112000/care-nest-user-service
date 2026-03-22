package com.carenest.user_service.model.common;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ApiResponse<T> {
    private LocalDateTime timeStamp;
    private Integer status;
    private String message;
    private T data;
    private Object errors;
}
