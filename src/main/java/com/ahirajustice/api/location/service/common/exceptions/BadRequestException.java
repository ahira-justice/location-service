package com.ahirajustice.api.location.service.common.exceptions;

import com.ahirajustice.api.location.service.common.constants.ErrorConstants;

public class BadRequestException extends ApplicationException {

    public BadRequestException(String errorDescription) {
        super(errorDescription, ErrorConstants.BAD_REQUEST, 400);
    }

    public BadRequestException(String errorDescription, String error) {
        super(errorDescription, error, 400);
    }

}
