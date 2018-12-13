package com.github.homespirit.hueaccesscontrol.bridge.api;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface DeleteApi<TId, TResponse> extends ResourceApi<TId> {

    ParameterizedTypeReference<TResponse> deleteResponseType();

    default ResponseEntity<TResponse> delete(TId id) {
        return delete(Map.of("id", id));
    }


    default ResponseEntity<TResponse> delete(Map<String, ?> params) {
        return template().exchange(
                resourcePath(),
                HttpMethod.DELETE,
                null,
                deleteResponseType(),
                params
        );
    }

}
