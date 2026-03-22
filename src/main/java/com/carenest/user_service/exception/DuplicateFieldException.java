package com.carenest.user_service.exception;

import java.util.Map;

public class DuplicateFieldException extends RuntimeException{
    private final Map<String, String> errors;
    public DuplicateFieldException(Map<String, String> errors){
        super("Duplicate fields");
        this.errors = errors;
    }
    public Map<String, String> getErrors(){
        return errors;
    }


}
