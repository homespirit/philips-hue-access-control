package com.github.homespirit.hueaccesscontrol.bridge.api;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

public interface UpdateApi<TId, TDto, TResponse> extends ResourceApi<TId> {

    ParameterizedTypeReference<TResponse> updateResponseType();

    default ResponseEntity<TResponse> update(TId id, TDto dto) {
        return template().exchange(
                path(id),
                HttpMethod.PUT,
                new HttpEntity<>(dto),
                updateResponseType()
        );
    }

}
