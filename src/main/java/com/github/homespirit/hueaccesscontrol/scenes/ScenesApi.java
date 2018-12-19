package com.github.homespirit.hueaccesscontrol.scenes;

import com.github.homespirit.hueaccesscontrol.bridge.api.HueCrudApi;
import com.github.homespirit.hueaccesscontrol.scenes.dto.Scene;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ScenesApi extends HueCrudApi<String, Scene> {

    @Override
    public String path() {
        return "/scenes";
    }

    @Override
    public ParameterizedTypeReference<Map<String, Scene>> listResponseType() {
        return new ParameterizedTypeReference<>() {
        };
    }

    @Override
    public ParameterizedTypeReference<Scene> readResponseType() {
        return new ParameterizedTypeReference<>() {
        };
    }
}
