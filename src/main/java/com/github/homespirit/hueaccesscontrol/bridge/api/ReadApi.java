package com.github.homespirit.hueaccesscontrol.bridge.api;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface ReadApi<TId, TDto> extends ResourceApi<TId> {

    ParameterizedTypeReference<TDto> readResponseType();

    default ResponseEntity<TDto> read(TId id) {
        return read(Map.of("id", id));
    }

    default ResponseEntity<TDto> read(Map<String, ?> params) {
        return template().exchange(
                resourcePath(),
                HttpMethod.GET,
                null,
                readResponseType(),
                params
        );
    }

}
