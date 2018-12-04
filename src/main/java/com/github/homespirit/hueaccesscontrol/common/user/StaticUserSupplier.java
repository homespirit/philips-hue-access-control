package com.github.homespirit.hueaccesscontrol.common.user;

public class StaticUserSupplier implements CurrentUserSupplier {

    private String userId;

    public StaticUserSupplier(String userId) {
        this.userId = userId;
    }

    @Override
    public String get() {
        return userId;
    }
}
