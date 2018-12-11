package com.github.homespirit.hueaccesscontrol.bridge.api;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

public interface ReadApi<TId, TDto> extends ResourceApi<TId> {

    ParameterizedTypeReference<TDto> readResponseType();

    default ResponseEntity<TDto> read(TId id) {
        return template().exchange(
                path(id),
                HttpMethod.GET,
                null,
                readResponseType()
        );
    }

}
