package com.github.homespirit.hueaccesscontrol.bridge.api;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UpdateApi<TId, TDto, TResponse> extends ResourceApi<TId> {

    ParameterizedTypeReference<TResponse> updateResponseType();

    default ResponseEntity<TResponse> update(TId id, TDto dto) {
        return update(dto, Map.of("id", id));
    }

    default ResponseEntity<TResponse> update(TDto dto, Map<String, ?> params) {
        return template().exchange(
                resourcePath(),
                HttpMethod.PUT,
                new HttpEntity<>(dto),
                updateResponseType(),
                params
        );
    }

}
