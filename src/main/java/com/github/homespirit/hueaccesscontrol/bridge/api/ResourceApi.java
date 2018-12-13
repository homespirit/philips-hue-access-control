package com.github.homespirit.hueaccesscontrol.bridge.api;

public interface ResourceApi<TId>  extends RestApi {

    default String resourcePath() {
        return path() + "/{id}";
    }

}
