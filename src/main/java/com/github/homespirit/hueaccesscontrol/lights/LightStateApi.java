package com.github.homespirit.hueaccesscontrol.lights;

import com.github.homespirit.hueaccesscontrol.bridge.api.HueApi;
import com.github.homespirit.hueaccesscontrol.bridge.api.HueCrudApi;
import com.github.homespirit.hueaccesscontrol.bridge.api.UpdateApi;
import com.github.homespirit.hueaccesscontrol.bridge.dto.UpdateStatus;
import com.github.homespirit.hueaccesscontrol.lights.dto.Light;
import com.github.homespirit.hueaccesscontrol.lights.dto.LightState;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LightStateApi extends HueApi implements UpdateApi<Integer, LightState, List<UpdateStatus>> {

    @Override
    public String path() {
        return "/lights/{id}/state";
    }

    @Override
    public ParameterizedTypeReference<List<UpdateStatus>> updateResponseType() {
        return new ParameterizedTypeReference<>() {
        };
    }
}
