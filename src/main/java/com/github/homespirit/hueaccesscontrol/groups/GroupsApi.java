package com.github.homespirit.hueaccesscontrol.groups;

import com.github.homespirit.hueaccesscontrol.bridge.api.HueCrudApi;
import com.github.homespirit.hueaccesscontrol.groups.dto.Group;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GroupsApi extends HueCrudApi<Integer, Group> {

    @Override
    public String path() {
        return "/groups";
    }

    @Override
    public ParameterizedTypeReference<Map<Integer, Group>> listResponseType() {
        return new ParameterizedTypeReference<>() {
        };
    }

    @Override
    public ParameterizedTypeReference<Group> readResponseType() {
        return new ParameterizedTypeReference<>() {
        };
    }
}
