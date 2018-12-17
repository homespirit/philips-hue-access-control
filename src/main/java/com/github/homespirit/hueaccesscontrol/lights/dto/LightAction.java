package com.github.homespirit.hueaccesscontrol.lights.dto;

import lombok.Data;

@Data
public class LightAction {

    private Boolean on;

    private Integer bri;

    private Integer hue;

    private Integer sat;

    private String effect;

    private CieColor xy;

    private Integer ct;

    private String alert;

    private String colormode;

}
