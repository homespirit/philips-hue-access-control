package com.github.homespirit.hueaccesscontrol.rules.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.homespirit.hueaccesscontrol.lights.dto.CieColor;
import com.github.homespirit.hueaccesscontrol.lights.dto.LightAction;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Rule {

    private String name;

    private String owner;

    private String created;

    private String lasttriggered;

    private Integer timestriggered;

    private String status;

    private Boolean recycle;

    private List<Condition> conditions;

    private List<Action> actions;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Condition {

        private String address;

        private String operator;

        private String value;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Action {

        private String address;

        private String method;

        private ActionBody body;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class ActionBody<TStatus> {

        private String scene;

        private TStatus status;

        @JsonProperty("bri_inc")
        private Integer briInc;

        private Integer transitiontime;

        private String localtime;

        private Boolean on;

        private Boolean storelightstate;

        private Integer bri;

        private Integer ct;

        private CieColor xy;

        private Boolean flag;
    }

}
