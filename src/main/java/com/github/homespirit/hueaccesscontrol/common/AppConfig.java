package com.github.homespirit.hueaccesscontrol.common;

import com.github.homespirit.hueaccesscontrol.GroupsConfig;
import com.github.homespirit.hueaccesscontrol.common.api.HueRestTemplate;
import com.github.homespirit.hueaccesscontrol.common.config.BridgeConfig;
import com.github.homespirit.hueaccesscontrol.common.user.CurrentUserSupplier;
import com.github.homespirit.hueaccesscontrol.common.user.RequestUserSupplier;
import com.github.homespirit.hueaccesscontrol.common.user.StaticUserSupplier;
import com.github.homespirit.hueaccesscontrol.lights.LightsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@Configuration
@EnableConfigurationProperties
public class AppConfig {

    @Autowired
    public void init(LightsConfig lightsConfig, GroupsConfig groupsConfig) {
        System.out.println("test");
    }

    @Bean
    public CurrentUserSupplier userSupplier(BridgeConfig bridgeConfig, HttpServletRequest request) {
        return bridgeConfig.getUser() == null ?
                new RequestUserSupplier(request) : new StaticUserSupplier(bridgeConfig.getUser());
    }

    @Bean
    public HueRestTemplate hueRestTemplate(BridgeConfig bridgeConfig, CurrentUserSupplier currentUserSupplier) {
        return new HueRestTemplate(bridgeConfig, currentUserSupplier, new RestTemplate());
    }

}
