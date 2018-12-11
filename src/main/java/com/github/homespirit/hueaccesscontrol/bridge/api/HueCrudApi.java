package com.github.homespirit.hueaccesscontrol.bridge.api;

import com.github.homespirit.hueaccesscontrol.bridge.dto.DeleteStatus;
import com.github.homespirit.hueaccesscontrol.bridge.dto.UpdateStatus;
import org.springframework.core.ParameterizedTypeReference;

import java.util.List;
import java.util.Map;

public abstract class HueCrudApi<TDto> extends HueApi implements ListApi<Map<Integer, TDto>>, ReadApi<Integer, TDto>,
        UpdateApi<Integer, TDto, List<UpdateStatus<?>>>, DeleteApi<Integer, List<DeleteStatus>> {

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
