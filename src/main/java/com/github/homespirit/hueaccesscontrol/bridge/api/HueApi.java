package com.github.homespirit.hueaccesscontrol.bridge.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
abstract public class HueApi implements RestApi {

    private HueRestTemplate hueRestTemplate;

    @Autowired
    public void setHueRestTemplate(HueRestTemplate hueRestTemplate) {
        this.hueRestTemplate = hueRestTemplate;
    }

    @Override
    public RestTemplate template() {
        return hueRestTemplate;
    }

}
