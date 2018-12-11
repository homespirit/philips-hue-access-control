package com.github.homespirit.hueaccesscontrol.bridge.api;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

public interface DeleteApi<TId, TResponse> extends ResourceApi<TId> {

    ParameterizedTypeReference<TResponse> deleteResponseType();

    default ResponseEntity<TResponse> delete(TId id) {
        return template().exchange(
                path(id),
                HttpMethod.DELETE,
                null,
                deleteResponseType()
        );
    }

}
