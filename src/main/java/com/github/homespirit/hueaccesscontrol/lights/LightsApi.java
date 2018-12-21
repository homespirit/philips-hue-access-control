package com.github.homespirit.hueaccesscontrol.lights;

import com.github.homespirit.hueaccesscontrol.bridge.api.HueCrudApi;
import com.github.homespirit.hueaccesscontrol.lights.dto.Light;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LightsApi extends HueCrudApi<Integer, Light> {

    @Override
    public String path() {
        return "/lights";
    }

    @Override
    public ParameterizedTypeReference<Map<Integer, Light>> listResponseType() {
        return new ParameterizedTypeReference<>() {
        };
    }

    @Override
    public ParameterizedTypeReference<Light> readResponseType() {
        return new ParameterizedTypeReference<>() {
        };
    }
}
