package com.github.homespirit.hueaccesscontrol.bridge.api;

import com.github.homespirit.hueaccesscontrol.bridge.dto.DeleteStatus;
import com.github.homespirit.hueaccesscontrol.bridge.dto.UpdateStatus;
import org.springframework.core.ParameterizedTypeReference;

import java.util.List;
import java.util.Map;

public abstract class HueCrudApi<TId, TDto> extends HueApi implements ListApi<Map<TId, TDto>>, ReadApi<TId, TDto>,
        UpdateApi<TId, TDto, List<UpdateStatus<?>>>, DeleteApi<TId, List<DeleteStatus>> {

    @Override
    public ParameterizedTypeReference<List<UpdateStatus<?>>> updateResponseType() {
        return new ParameterizedTypeReference<>() {
        };
    }

    @Override
    public ParameterizedTypeReference<List<DeleteStatus>> deleteResponseType() {
        return new ParameterizedTypeReference<>() {
        };
    }
}
