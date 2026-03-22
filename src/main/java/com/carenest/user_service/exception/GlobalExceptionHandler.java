package com.carenest.user_service.exception;

import com.carenest.user_service.model.common.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public ResponseEntity<ApiResponse<Object>> handleDuplicate(DuplicateFieldException ex){
        ApiResponse<Object>  response = ApiResponse.builder()
                .timeStamp(LocalDateTime.now())
                .status(400)
                .message("validation failed")
                .errors(ex.getErrors())
                .build();
        return ResponseEntity.badRequest().body(response);



    }


}
