package com.github.homespirit.hueaccesscontrol.bridge.api;

import com.github.homespirit.hueaccesscontrol.bridge.dto.DeleteStatus;
import com.github.homespirit.hueaccesscontrol.bridge.dto.UpdateStatus;

import java.util.List;
import java.util.Map;

public interface CrudApi<TId, TDto> extends
        ListApi<Map<Integer, TDto>>,
        ReadApi<TId, TDto>,
        UpdateApi<TId, TDto, List<UpdateStatus<?>>>,
        DeleteApi<TId, List<DeleteStatus>> {

}
