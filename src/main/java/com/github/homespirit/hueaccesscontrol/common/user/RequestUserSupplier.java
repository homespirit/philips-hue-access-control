package com.github.homespirit.hueaccesscontrol.common.user;

import com.github.homespirit.hueaccesscontrol.common.user.exception.CannotSupplyUser;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

public class RequestUserSupplier implements CurrentUserSupplier {

    private HttpServletRequest request;

    public RequestUserSupplier(HttpServletRequest request) {
        this.request = request;
    }

    public String get() {
        var pattern = Pattern.compile("(?<=^\\/api\\/)(?!\\/).*(?=\\/)"); // todo
        var matcher = pattern.matcher(request.getServletPath());
        if (matcher.find()) {
            return matcher.group();
        }
        throw new CannotSupplyUser("UserId cannot be extracted from path.");
    }

}
