package com.github.homespirit.hueaccesscontrol.groups;

import com.github.homespirit.hueaccesscontrol.bridge.api.HueCrudApi;
import com.github.homespirit.hueaccesscontrol.lights.dto.Light;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GroupsApi extends HueCrudApi<Light> {

    @Override
    public String path() {
        return "/groups";
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
