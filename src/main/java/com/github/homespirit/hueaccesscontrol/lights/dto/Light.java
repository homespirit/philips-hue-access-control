package com.github.homespirit.hueaccesscontrol.lights.dto;

import com.github.homespirit.hueaccesscontrol.common.api.dto.Device;
import lombok.Data;

@Data
public class Light extends Device {

    private LightState state;

    private String type;

    private String modelid;

    private String manufacturername;

    private String productname;

    private Capabilities capabilities;

    private Config config;

    private String uniqueid;

    private String swversion;

    @Data
    public static class Config {

        private String archetype;

        private String function;

        private String direction;

    }

}
