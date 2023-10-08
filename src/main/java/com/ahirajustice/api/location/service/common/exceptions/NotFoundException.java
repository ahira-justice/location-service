package com.ahirajustice.api.location.service.common.exceptions;

import com.ahirajustice.api.location.service.common.constants.ErrorConstants;

public class NotFoundException extends ApplicationException {

    public NotFoundException(String errorDescription) {
        super(errorDescription, ErrorConstants.NOT_FOUND, 404);
    }

}
