package com.github.homespirit.hueaccesscontrol.common.api;

public interface HueApiDefinition<TDto> {

    String path();

    Class<TDto> type();

}
