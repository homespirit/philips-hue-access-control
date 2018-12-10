package com.github.homespirit.hueaccesscontrol.lights;

import com.github.homespirit.hueaccesscontrol.common.api.HueApiDefinition;
import com.github.homespirit.hueaccesscontrol.lights.dto.Light;

public class LightsApi implements HueApiDefinition<Light> {

    public static final LightsApi DEFINITION = new LightsApi();

    @Override
    public String path() {
        return "lights";
    }

    @Override
    public Class<Light> type() {
        return Light.class;
    }
}
