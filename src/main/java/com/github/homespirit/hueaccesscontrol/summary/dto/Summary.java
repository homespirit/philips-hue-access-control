package com.github.homespirit.hueaccesscontrol.summary.dto;

import com.github.homespirit.hueaccesscontrol.lights.dto.Light;
import lombok.Data;

import java.util.Map;

@Data
public class Summary {

    private Map<Integer, Light> lights;

}
