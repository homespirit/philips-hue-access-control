package com.github.homespirit.hueaccesscontrol.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.homespirit.hueaccesscontrol.GroupsConfig;
import com.github.homespirit.hueaccesscontrol.bridge.api.HueRestTemplate;
import com.github.homespirit.hueaccesscontrol.bridge.config.BridgeConfig;
import com.github.homespirit.hueaccesscontrol.common.user.CurrentUserSupplier;
import com.github.homespirit.hueaccesscontrol.common.user.RequestUserSupplier;
import com.github.homespirit.hueaccesscontrol.common.user.StaticUserSupplier;
import com.github.homespirit.hueaccesscontrol.lights.LightsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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
        var restTemplate = new HueRestTemplate(bridgeConfig, currentUserSupplier);
        var converters = new ArrayList<HttpMessageConverter<?>>(List.of(createHueRestMessageConverter()));
        converters.addAll(restTemplate.getMessageConverters());
        restTemplate.setMessageConverters(converters);
        return restTemplate;
    }

    private ObjectMapper createHueRestObjectMapper() {
        var objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper;
    }

    private HttpMessageConverter<?> createHueRestMessageConverter() {
        var jacksonConverter = new MappingJackson2HttpMessageConverter();
        jacksonConverter.setObjectMapper(createHueRestObjectMapper());
        return jacksonConverter;
    }

}
