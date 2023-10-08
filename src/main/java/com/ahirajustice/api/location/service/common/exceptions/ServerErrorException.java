package com.ahirajustice.api.location.service.common.exceptions;

import com.ahirajustice.api.location.service.common.constants.ErrorConstants;

public class ServerErrorException extends ApplicationException {

    public ServerErrorException() {
        super(
                "An unexpected error occurred. Please try again or confirm server operation status",
                ErrorConstants.SERVER_ERROR,
                500
        );
    }

}
