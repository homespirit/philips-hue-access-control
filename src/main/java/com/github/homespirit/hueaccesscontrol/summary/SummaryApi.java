package com.github.homespirit.hueaccesscontrol.summary;

import com.github.homespirit.hueaccesscontrol.bridge.api.HueApi;
import com.github.homespirit.hueaccesscontrol.bridge.api.ListApi;
import com.github.homespirit.hueaccesscontrol.bridge.api.ReadApi;
import com.github.homespirit.hueaccesscontrol.summary.dto.Summary;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

@Service
public class SummaryApi extends HueApi implements ListApi<Summary> {

    @Override
    public String path() {
        return "";
    }

    @Override
    public ParameterizedTypeReference<Summary> listResponseType() {
        return new ParameterizedTypeReference<>() {
        };
    }
}
