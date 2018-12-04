package com.github.homespirit.hueaccesscontrol.common.user.exception;

public class CannotSupplyUser extends RuntimeException {
    public CannotSupplyUser(String reason) {
        super(reason);
    }
}
