package com.github.homespirit.hueaccesscontrol.groups.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.homespirit.hueaccesscontrol.lights.dto.LightAction;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Group {

    private String name;

    private List<String> lights;

    private List<String> sensors;

    private String type;

    private State state;

    private Boolean recycle;

    @JsonProperty("class")
    private String classname;

    private Stream stream;

    private Map<Integer, List<Double>> locations;

    private LightAction action;

    @Data
    private static class State {

        @JsonProperty("any_on")
        private Boolean anyOn;

        @JsonProperty("all_on")
        private Boolean allOn;

    }

    @Data
    private static class Stream {

        private String proxymode;

        private String proxynode;

        private Boolean active;

        private String owner;

    }

}
