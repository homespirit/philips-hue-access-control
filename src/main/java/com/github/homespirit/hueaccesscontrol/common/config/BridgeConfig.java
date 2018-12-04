package com.github.homespirit.hueaccesscontrol.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Data
@Component
@ConfigurationProperties("hue.bridge")
public class BridgeConfig {

    private static String URL_TEMPLATE = "%s://%s:%s/api/%s/%s";

    @NotNull
    private String hostname;

    private int port = 80;

    private String protocol = "http";

    private String user;

    public String createPath(String userId, String subPath) {
        return String.format(
                URL_TEMPLATE,
                getProtocol(),
                getHostname(),
                getPort(),
                userId,
                subPath
        );
    }

}
