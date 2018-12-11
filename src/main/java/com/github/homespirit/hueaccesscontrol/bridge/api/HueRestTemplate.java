package com.github.homespirit.hueaccesscontrol.bridge.api;

import com.github.homespirit.hueaccesscontrol.bridge.config.BridgeConfig;
import com.github.homespirit.hueaccesscontrol.common.user.CurrentUserSupplier;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

public class HueRestTemplate extends RestTemplate {

    private BridgeConfig bridgeConfig;

    private CurrentUserSupplier currentUserSupplier;

    public HueRestTemplate(BridgeConfig bridgeConfig, CurrentUserSupplier currentUserSupplier) {
        this.bridgeConfig = bridgeConfig;
        this.currentUserSupplier = currentUserSupplier;
    }

    @Override
    protected <T> T doExecute(URI url, HttpMethod method, RequestCallback requestCallback, ResponseExtractor<T> responseExtractor) throws RestClientException {
        var path = bridgeConfig.createPath(
                currentUserSupplier.get(),
                url.getPath()
        );
        return super.doExecute(URI.create(path), method, requestCallback, responseExtractor);
    }

}

