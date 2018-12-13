package com.github.homespirit.hueaccesscontrol.common.user;

import com.github.homespirit.hueaccesscontrol.bridge.Api;
import com.github.homespirit.hueaccesscontrol.common.user.exception.CannotSupplyUser;

import javax.servlet.http.HttpServletRequest;

public class RequestUserSupplier implements CurrentUserSupplier {

    private HttpServletRequest request;

    public RequestUserSupplier(HttpServletRequest request) {
        this.request = request;
    }

    public String get() {
        var matcher = Api.USER_ID_PATTERN.matcher(request.getServletPath());
        if (matcher.find()) {
            return matcher.group();
        }
        throw new CannotSupplyUser("UserId cannot be extracted from resourcePath.");
    }

}
