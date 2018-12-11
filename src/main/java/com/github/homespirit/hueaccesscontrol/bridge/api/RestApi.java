package com.github.homespirit.hueaccesscontrol.bridge.api;

import org.springframework.web.client.RestTemplate;

public interface RestApi {

    String path();

    RestTemplate template();

}
