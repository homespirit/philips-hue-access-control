package com.github.homespirit.hueaccesscontrol.rules;

import com.github.homespirit.hueaccesscontrol.bridge.api.HueCrudApi;
import com.github.homespirit.hueaccesscontrol.rules.dto.Rule;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RulesApi extends HueCrudApi<Integer, Rule> {

    @Override
    public String path() {
        return "/rules";
    }

    @Override
    public ParameterizedTypeReference<Map<Integer, Rule>> listResponseType() {
        return new ParameterizedTypeReference<>() {
        };
    }

    @Override
    public ParameterizedTypeReference<Rule> readResponseType() {
        return new ParameterizedTypeReference<>() {
        };
    }
}
