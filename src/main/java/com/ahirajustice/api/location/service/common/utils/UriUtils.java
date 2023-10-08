package com.ahirajustice.api.location.service.common.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UriUtils {

    public static boolean uriMatch(String requestUri, String requestMethod, String uriMethodCsv) {
        String uri = uriMethodCsv.split(", ")[0];
        String method = uriMethodCsv.split(", ")[1];

        if (uri.equals(requestUri) && method.equals(requestMethod))
            return true;

        return uri.endsWith("/**") &&
                requestUri.startsWith(uri.replace("/**", "")) &&
                method.equals(requestMethod);
    }

}
