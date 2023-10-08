package com.ahirajustice.api.location.service.common.error;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ValidationErrorResponse extends ErrorResponse {
    
    private Map<String, String> errors;

    public ValidationErrorResponse() {
        super();
    }

}
