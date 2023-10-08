package com.ahirajustice.api.location.service.common.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SecurityConstants {

    public static final String[] EXCLUDE_FROM_REQUEST_RESPONSE_LOGGER = new String[] {
            "/**, OPTIONS"
    };

}
