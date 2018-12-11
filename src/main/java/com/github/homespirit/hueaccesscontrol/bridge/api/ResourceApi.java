package com.github.homespirit.hueaccesscontrol.bridge.api;

public interface ResourceApi<TId>  extends RestApi {

    default String path(TId id) {
        return path() + '/' + id;
    }

}
