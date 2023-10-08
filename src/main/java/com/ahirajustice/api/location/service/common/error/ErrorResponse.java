package com.ahirajustice.api.location.service.common.error;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorResponse {

    private String error;
    private String errorDescription;
    private LocalDateTime timestamp;

    public ErrorResponse() {
        this.timestamp = LocalDateTime.now();
    }

    public String getTimestamp() {
        return this.timestamp.toString();
    }

}
