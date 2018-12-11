package com.github.homespirit.hueaccesscontrol.bridge.api;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

public interface ListApi<TResponse> extends RestApi {

    ParameterizedTypeReference<TResponse> listResponseType();

    default ResponseEntity<TResponse> list() {
        return template().exchange(
                path(),
                HttpMethod.GET,
                null,
                listResponseType()
        );
    }

}
