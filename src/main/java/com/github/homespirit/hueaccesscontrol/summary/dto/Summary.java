package com.github.homespirit.hueaccesscontrol.summary.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.homespirit.hueaccesscontrol.groups.dto.Group;
import com.github.homespirit.hueaccesscontrol.lights.dto.Light;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Summary {

    private Map<Integer, Light> lights;

    private Map<Integer, Group> groups;

}
