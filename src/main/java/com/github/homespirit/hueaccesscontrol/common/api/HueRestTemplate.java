package com.github.homespirit.hueaccesscontrol.common.api;

import com.github.homespirit.hueaccesscontrol.common.config.BridgeConfig;
import com.github.homespirit.hueaccesscontrol.common.user.CurrentUserSupplier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class HueRestTemplate {

    private BridgeConfig bridgeConfig;

    private CurrentUserSupplier currentUserSupplier;

    private RestTemplate restTemplate;

    public HueRestTemplate(BridgeConfig bridgeConfig, CurrentUserSupplier currentUserSupplier, RestTemplate restTemplate) {
        this.bridgeConfig = bridgeConfig;
        this.currentUserSupplier = currentUserSupplier;
        this.restTemplate = restTemplate;
    }

    public <TDto> ResponseEntity<Map<Integer, TDto>> list(HueApiDefinition<TDto> apiDefinition) {
        return restTemplate.exchange(
                bridgeConfig.createPath(
                        currentUserSupplier.get(),
                        apiDefinition.path()
                ),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Map<Integer, TDto>>() {
                }
        );
    }

}
