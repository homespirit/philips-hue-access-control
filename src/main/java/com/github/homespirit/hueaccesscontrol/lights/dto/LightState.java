package com.github.homespirit.hueaccesscontrol.lights.dto;

import lombok.Data;

@Data
public class LightState extends LightAction {

    private String mode;

    private Boolean reachable;

}
